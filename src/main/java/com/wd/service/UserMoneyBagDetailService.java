package com.wd.service;

import com.wd.data.ResponseData;
import com.wd.data.payment.*;
import com.wd.data.payment.xml.WeChatPayNotifyInfo;

/**
 * Created by Zhipeng on 2016/5/10.
 */
public interface UserMoneyBagDetailService {
    /**
     * 获取交易记录
     * @param UserId
     * @return
     */
    public ResponseData getDetailByUserId(Long UserId);


    /**
     * 获取签名
     * @param directPayByUserInfo
     * @return
     */
    public ResponseData getSign(DirectPayByUserInfo directPayByUserInfo);


    /**
     * 保存交易记录
     */
    public ResponseData saveRecord(SubmitOrderInfo submitOrderInfo);

    /**
     * 处理支付宝回复
     */
    public String handleReply(DirectPayResponseInfo directPayResponseInfo);

    /**
     * 获取钱包
     * @param UserId
     * @return
     */
    public ResponseData getByUserId(Long UserId);

    /**
     * 对钱包进行操作
     * @param
     * @param
     * @return
     */
    public ResponseData changeAmount(SubmitOrderInfo submitOrderInfo);


    /**
     * 确认付款
     */
    public void confirmPayment(ConfirmPaymentInfo confirmPaymentInfo);

    /**
     * 确认退款
     * @param refundResponseInfo
     * @return
     */
    public String changeAmount(RefundResponseInfo refundResponseInfo);


    /**
     * 判断交易状态
     */
    public boolean getDetailState(Long id);

    /**
     * webchat notify_url
     */
    public String handlerWeChatPayment(WeChatPayNotifyInfo weChatPayNotifyInfo);

    /**
     * 打赏/转账
     */
    public ResponseData directPayByMoneyBag(Long currentUserId, Long payToUserId, long amount);
}
