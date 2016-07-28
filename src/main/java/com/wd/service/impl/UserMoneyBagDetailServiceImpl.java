package com.wd.service.impl;

import com.wd.common.PaymentOperationState;
import com.wd.dao.*;
import com.wd.data.ResponseData;
import com.wd.data.payment.*;
import com.wd.data.payment.xml.WeChatPayNotifyInfo;
import com.wd.data.payment.xml.WeChatPayNotifyReturnInfo;
import com.wd.domain.*;
import com.wd.service.UserMoneyBagDetailService;
import com.wd.utils.BeanToMapUtils;
import com.wd.utils.MoneyNotEnoughInBagException;
import com.wd.utils.RelativeRecordException;
import com.wd.utils.XMLObjectParser;
import com.wd.utils.alipay.util.AlipayCore;
import com.wd.utils.alipay.util.AlipayNotify;
import com.wd.utils.wechat.pay.utils.WeChatUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhipeng on 2016/5/12.
 */
@Service
public class UserMoneyBagDetailServiceImpl implements UserMoneyBagDetailService {
    Logger logger = Logger.getLogger(UserMoneyBagDetailServiceImpl.class);

    @Autowired
    private UserMoneyBagDao bagDao;
    @Autowired
    private UserMoneyBagDetailDao bagDetailDao;
    @Autowired
    private UserMoneyBagDetailRelativeDao relativeDao;


    /**
     * 获取交易记录
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseData getDetailByUserId(Long userId) {
        try {
            List<UserMoneyBagDetailEntity> entities = bagDetailDao.findByUserId(userId);
            return new ResponseData(true, "获取交易记录成功", entities);
        } catch (Exception e) {
            return new ResponseData(false, "获取交易记录失败", null);
        }
    }


    /**
     * 获取签名
     *
     * @param directPayByUserInfo
     * @return
     */
    @Override
    public ResponseData getSign(DirectPayByUserInfo directPayByUserInfo) {
        try {
            Map<String, String> map = BeanToMapUtils.describe(directPayByUserInfo);
            String mySign = AlipayCore.buildMysign(map);
            return new ResponseData(true, "获取签名 并保存交易记录成功", mySign);
        } catch (Exception e) {
            return new ResponseData(false, "获取签名 并保存交易记录失败", null);
        }
    }

    /**
     * 保存交易记录
     *
     * @param submitOrderInfo
     */
    @Override
    public ResponseData saveRecord(SubmitOrderInfo submitOrderInfo) {
        try {
            UserMoneyBagDetailEntity detailEntity = render(submitOrderInfo);
            UserMoneyBagDetailEntity detailEntity1 = bagDetailDao.save(detailEntity);
            Long id = detailEntity1.getId();
            if (detailEntity1.getOperationType() != PaymentOperationState.operation_bag) {
                saveOrderInfos(detailEntity1.getOperationType(), submitOrderInfo.getRelativeInfos(), id, relativeDao, true);
            }
            return new ResponseData(true, "保存交易记录成功", id);
        } catch (RelativeRecordException e) {
            return new ResponseData(false, e.getMessage(), null);
        } catch (Exception e) {
            return new ResponseData(false, "保存交易记录失败", null);
        }
    }

    /**
     * 处理支付宝 直接支付接口回复
     *
     * @param directPayResponseInfo
     */
    @Override
    @Transactional
    public String handleReply(DirectPayResponseInfo directPayResponseInfo) {
        try {
//            if (verifyResponse(directPayResponseInfo)) {
            logger.info(directPayResponseInfo);
            String id = directPayResponseInfo.getOut_trade_no();
            String trade_status = directPayResponseInfo.getTrade_status();

            logger.info("current trade status " + trade_status);
            switch (trade_status) {
                case PaymentOperationState.alipay_trade_status_trade_success:
                    tradSuccess(directPayResponseInfo);
                    break;
                case PaymentOperationState.alipay_trade_status_trade_pending:
                    tradSuccess(directPayResponseInfo);
                    break;
                default:
                    tradSuccess(directPayResponseInfo);
                    break;
            }
            return "success";
//            } else {
//                logger.error("支付宝消息有误");
//                return "fail";
//            }
        } catch (RelativeRecordException e) {
            logger.trace(e.getMessage(), e);
            return "fail";
        } catch (Exception e) {
            logger.trace("处理支付宝回复时发生bug", e);
            return "fail";
        }
    }


    private void tradSuccess(DirectPayResponseInfo directPayResponseInfo) throws RelativeRecordException {
        String id = directPayResponseInfo.getOut_trade_no();
        Long idL = Long.parseLong(id);
        UserMoneyBagDetailEntity detailEntity2 = bagDetailDao.findOne(idL);
        handleReplys(detailEntity2, directPayResponseInfo);
        addAmountToBag(detailEntity2);
    }

    private boolean decidenextState(String nextState) {
        return nextState.equals(PaymentOperationState.alipay_trade_status_trade_success) ||
                nextState.equals(PaymentOperationState.alipay_trade_status_trade_pending) ||
                nextState.equals(PaymentOperationState.alipay_trade_status_trade_finished);
    }

    private void confirmPayment(UserMoneyBagDetailEntity detailEntity2) throws RelativeRecordException {
        int operationType = detailEntity2.getOperationType();
        Long refId = detailEntity2.getId();
        List<UserMoneyBagDetailRelativeEntity> list = relativeDao.findByRefId(refId);
        for (UserMoneyBagDetailRelativeEntity u : list) {
            handlerRelativeOrder(operationType, u.getRelativeId());
        }
    }

    private void sendAdvice(List<UserMoneyBagDetailRelativeEntity> list) {
    }

    /**
     * 往钱包里充值(或别人转账)的时候用的方法
     */
    private void addAmountToBag(UserMoneyBagDetailEntity detailEntity) {
        Long userId = detailEntity.getUserId();
        Long amount = detailEntity.getAmount();
        logger.info("has delivery before?  " + detailEntity.isDeliveryToUser());
        if (!(detailEntity.isDeliveryToUser())) {
            addAmountToBag(userId, amount);
            detailEntity.setDeliveryToUser(true);
            bagDetailDao.save(detailEntity);
            logger.info(" after payment " + detailEntity);
        }
    }

    /**
     * 验证消息的完整性
     *
     * @param directPayResponseInfo
     * @return
     */
    private boolean verifyResponse(DirectPayResponseInfo directPayResponseInfo) {
        Map<String, String> map = BeanToMapUtils.describe(directPayResponseInfo);
        return AlipayNotify.verify(map);
    }

    /**
     * 处理支付宝回复消息
     *
     * @param detailEntity2
     * @param directPayResponseInfo
     */
    private void handleReplys(UserMoneyBagDetailEntity detailEntity2, DirectPayResponseInfo directPayResponseInfo) {
        String trade_no = directPayResponseInfo.getTrade_no();
        String buyerEmail = directPayResponseInfo.getBuyer_email();
        String buyerId = directPayResponseInfo.getBuyer_id();
        String notifyId = directPayResponseInfo.getNotify_id();
        String trade_status = directPayResponseInfo.getTrade_status();

        detailEntity2.setTradeStatus(trade_status);
        detailEntity2.setTradeNo(trade_no);
        detailEntity2.setBuyerEmail(buyerEmail);
        detailEntity2.setBuyerId(buyerId);
        detailEntity2.setNotifyId(notifyId);
        bagDetailDao.save(detailEntity2);
    }

    /**
     * 将SubmitOrderInfo 转换成
     *
     * @param submitOrderInfo
     * @return
     */
    public static UserMoneyBagDetailEntity render(SubmitOrderInfo submitOrderInfo) {
        Long userId;
        Long amount;
        int operationType;
        int sourceDevice;
        int paymentType;
        userId = submitOrderInfo.getUserId();
        amount = submitOrderInfo.getAmount();
        operationType = submitOrderInfo.getOperationType();
        sourceDevice = submitOrderInfo.getSourceDevice();
        paymentType = submitOrderInfo.getPaymentType();
        boolean outOrIn = submitOrderInfo.isOutOrIn();
        return new UserMoneyBagDetailEntity(userId, amount, operationType, sourceDevice, paymentType, outOrIn);
    }

    /**
     * 保存 关联明细
     *
     * @param orderRelativeInfos
     * @param id
     */
    public void saveOrderInfos(int operationType, List<OrderRelativeInfo> orderRelativeInfos, Long id, UserMoneyBagDetailRelativeDao relativeDao,
                               boolean operate) throws RelativeRecordException {
        for (OrderRelativeInfo o : orderRelativeInfos) {
            saveOrderInfo(operationType, o, id, relativeDao, operate);
        }
    }

    /**
     * 保存单个关联明细
     *
     * @param o
     * @param id
     */
    public void saveOrderInfo(int operationType, OrderRelativeInfo o, Long id, UserMoneyBagDetailRelativeDao relativeDao,
                              boolean operate) throws RelativeRecordException {
        Long refId = id;
        Long amount = o.getAmount();
        Long relativeId = o.getRelativeId();
        relativeDao.save(new UserMoneyBagDetailRelativeEntity(refId, amount, relativeId));
        if (operate)
            handlerRelativeOrder(operationType, relativeId);

    }

    private void handlerRelativeOrder(int operationType, Long relativeId) throws RelativeRecordException {
    }

    /**
     * 获取钱包
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseData getByUserId(Long userId) {
        try {
            UserMoneyBagEntity userMoneyBagEntity = bagDao.findByUserId(userId);
            UserMoneyBagEntity userMoneyBagEntity1 = null;
            if (userMoneyBagEntity == null) {
                userMoneyBagEntity = new UserMoneyBagEntity(userId, 0L);
                userMoneyBagEntity1 = bagDao.save(userMoneyBagEntity);
                userMoneyBagEntity = userMoneyBagEntity1;
            }
            return new ResponseData(true, "获取钱包成功", userMoneyBagEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "获取钱包失败", null);
        }
    }

    /**
     * 对钱包进行操作
     *
     * @param submitOrderInfo
     * @return
     */
    @Override
    @Transactional
    public ResponseData changeAmount(SubmitOrderInfo submitOrderInfo) {
        UserMoneyBagDetailEntity detailEntity, detailEntity1 = null;
        try {
            detailEntity = UserMoneyBagDetailServiceImpl.render(submitOrderInfo);
            detailEntity1 = bagDetailDao.save(detailEntity);
            payOperation(detailEntity1.getAmount(), bagDao.findByUserId(detailEntity1.getUserId()));
            saveOrderInfos(detailEntity1.getOperationType(), submitOrderInfo.getRelativeInfos(), detailEntity1.getId(), relativeDao, true);

            return new ResponseData(true, "保存交易记录成功,付款成功", null);
        } catch (MoneyNotEnoughInBagException e) {
            deleteDetailEntity(detailEntity1);
            return new ResponseData(false, "保存交易记录失败,钱包余额不足", null);
        } catch (RelativeRecordException e) {
            deleteRelativeInfos(detailEntity1);
            deleteDetailEntity(detailEntity1);
            logger.trace(e.getMessage(), e);
            return new ResponseData(false, e.getMessage(), null);
        } catch (Exception e) {
            deleteRelativeInfos(detailEntity1);
            deleteDetailEntity(detailEntity1);
            e.printStackTrace();
            return new ResponseData(false, "系统问题交易失败", null);
        }
    }

    private void deleteRelativeInfos(UserMoneyBagDetailEntity detailEntity1) {
        int operationType = detailEntity1.getOperationType();
        List<UserMoneyBagDetailRelativeEntity> entities = relativeDao.findByRefId(detailEntity1.getId());
        for (UserMoneyBagDetailRelativeEntity e : entities) {

            relativeDao.delete(e);
        }
    }

    private void deleteDetailEntity(UserMoneyBagDetailEntity detailEntity1) {
        bagDetailDao.delete(detailEntity1);
    }

    /**
     * 系统预付款
     *
     * @param amount
     * @param userMoneyBag
     * @throws MoneyNotEnoughInBagException
     */
    private void payOperation(Long amount, UserMoneyBagEntity userMoneyBag) throws MoneyNotEnoughInBagException {
        Long a = userMoneyBag.getAmount();
        if (a >= amount) {
            Long result = a - amount;
            userMoneyBag.setAmount(result);
            bagDao.save(userMoneyBag);
        } else {
            throw new MoneyNotEnoughInBagException("余额不足");
        }
    }

    /**
     * 确认付款
     *
     * @param confirmPaymentInfo
     */
    @Override
    @Transactional
    public void confirmPayment(ConfirmPaymentInfo confirmPaymentInfo) {
        try {
            UserMoneyBagDetailEntity userMoneyBagDetailEntity = render(confirmPaymentInfo);

            UserMoneyBagDetailEntity userMoneyBagDetailEntity1 = bagDetailDao.save(userMoneyBagDetailEntity);

            saveOrderInfos(confirmPaymentInfo.getOperationType(), confirmPaymentInfo.getRelativeInfos(), userMoneyBagDetailEntity1.getId(), relativeDao, false);

            addAmountToBag(userMoneyBagDetailEntity1);
        } catch (RelativeRecordException e) {
            logger.info(e.getMessage());
        }
    }

    private void addAmountToBag(Long userId, Long amount) {
        UserMoneyBagEntity bag = bagDao.findByUserId(userId);
        Long d = bag.getAmount();
        logger.info("previous amount" + d + " add " + amount);
        Long r = d + amount;
        logger.info("current amount " + r);
        bag.setAmount(r);
        bagDao.save(bag);
    }


    private UserMoneyBagDetailEntity render(ConfirmPaymentInfo confirmPaymentInfo) {
        Long userId;
        long amount;
        int operationType;
        int sourceDevice;
        int paymentType;
        userId = confirmPaymentInfo.getUserId();
        amount = confirmPaymentInfo.getAmount();
        sourceDevice = confirmPaymentInfo.getSourceDevice();
        operationType = confirmPaymentInfo.getOperationType();
        paymentType = confirmPaymentInfo.getPaymentType();
        boolean outOrIn = false;
        return new UserMoneyBagDetailEntity(userId, amount, operationType, sourceDevice, paymentType, outOrIn);
    }

    /**
     * 确认退款
     *
     * @param refundResponseInfo
     * @return
     */
    @Override
    public String changeAmount(RefundResponseInfo refundResponseInfo) {
        try {

            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    /**
     * 判断交易状态
     *
     * @param id
     */
    @Override
    public boolean getDetailState(Long id) {

        UserMoneyBagDetailEntity detail = bagDetailDao.findOne(id);
        return detail.isDeliveryToUser();
    }

    /**
     * webchat notify_url
     *
     * @param weChatPayNotifyInfo
     */
    @Override
    public String handlerWeChatPayment(WeChatPayNotifyInfo weChatPayNotifyInfo) {

        try {
            if (WeChatUtil.SUCCESS_CODE.equals(weChatPayNotifyInfo.getResult_code()) && WeChatUtil.SUCCESS_CODE.equals(weChatPayNotifyInfo.getReturn_code())) {

                String out_trade_no = weChatPayNotifyInfo.getOut_trade_no();
                UserMoneyBagDetailEntity userMoneyBagDetailEntity = bagDetailDao.findOne(Long.getLong(out_trade_no));
                if (userMoneyBagDetailEntity.isDeliveryToUser())
                    return XMLObjectParser.Object2XmlString(new WeChatPayNotifyReturnInfo(WeChatUtil.SUCCESS_CODE, WeChatUtil.SUCCESS_CODE));
                else {
                    addAmountToBag(userMoneyBagDetailEntity);

                    return XMLObjectParser.Object2XmlString(new WeChatPayNotifyReturnInfo(WeChatUtil.SUCCESS_CODE, WeChatUtil.SUCCESS_CODE));
                }

            }
            return XMLObjectParser.Object2XmlString(new WeChatPayNotifyReturnInfo(WeChatUtil.FAIL_CODE, WeChatUtil.FAIL_CODE));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 打赏/转账
     *
     * @param currentUserId
     * @param payToUserId
     * @param amount
     */
    @Override
    public ResponseData directPayByMoneyBag(Long currentUserId, Long payToUserId, long amount) {
        UserMoneyBagDetailEntity detailEntity = null, detailEntity1 = null;
        try {
            detailEntity = createDirectPayRecorde(currentUserId, payToUserId, amount, true);
            detailEntity1 = createDirectPayRecorde(currentUserId,payToUserId,amount,false);
            payOperation(amount, bagDao.findByUserId(currentUserId));
            addAmountToBag(payToUserId,amount);
//            saveOrderInfos(detailEntity1.getOperationType(), null, detailEntity1.getId(), relativeDao, true);
            return new ResponseData(true, "保存交易记录成功,付款成功", null);
        } catch (MoneyNotEnoughInBagException e) {
            deleteDetailEntity(detailEntity);
            deleteDetailEntity(detailEntity1);
            return new ResponseData(false, "保存交易记录失败,钱包余额不足", null);
        } catch (Exception e) {
            deleteDetailEntity(detailEntity);
            deleteDetailEntity(detailEntity1);
            e.printStackTrace();
            return new ResponseData(false, "系统问题交易失败", null);
        }
    }

    private UserMoneyBagDetailEntity createDirectPayRecorde(Long currentUserId, Long payToUserId, Long amount, boolean b) {
        int operationType = PaymentOperationState.operation_bag;
        int paymentType = PaymentOperationState.payment_bag;
        boolean inOut;
        if (b) {
            inOut = PaymentOperationState.bag_operation_out;
            UserMoneyBagDetailEntity u = new UserMoneyBagDetailEntity(currentUserId, payToUserId, null ,amount, operationType, paymentType, inOut);
            return bagDetailDao.save(u);
        } else {
            inOut = PaymentOperationState.bag_operation_in;
            UserMoneyBagDetailEntity u = new UserMoneyBagDetailEntity(payToUserId,null , currentUserId ,amount, operationType, paymentType, inOut);
            return bagDetailDao.save(u);
        }

    }


}
