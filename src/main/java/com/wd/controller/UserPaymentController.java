package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.data.payment.DirectPayByUserInfo;
import com.wd.data.payment.DirectPayResponseInfo;
import com.wd.data.payment.RefundResponseInfo;
import com.wd.data.payment.SubmitOrderInfo;
import com.wd.data.payment.xml.WeChatPayDirectPay;
import com.wd.data.payment.xml.WeChatPayNotifyInfo;
import com.wd.service.UserMoneyBagDetailService;
import com.wd.utils.UnknowOperationTypeException;
import com.wd.utils.alipay.android.PayDemoActivity;
import com.wd.utils.wechat.pay.utils.WeChatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Zhipeng on 2016/5/11.
 */
@Controller
@RequestMapping("/web/payment")
public class UserPaymentController {


    @Autowired
    private UserMoneyBagDetailService detailService;


    @RequestMapping(value = "/get_money_bag", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData save(@RequestParam("userId") Long userId) {
        return detailService.getByUserId(userId);
    }

    /**
     * 获取交易记录
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get_payment_details", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getByUserId(@RequestParam("userId") Long userId) {
        return detailService.getDetailByUserId(userId);
    }

    /**
     * 获取签名
     *
     * @param directPayByUserInfo
     * @return
     */
    @RequestMapping(value = "/get_sign", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData getSign(@RequestBody DirectPayByUserInfo directPayByUserInfo) {
        return detailService.getSign(directPayByUserInfo);
    }


    /**
     * 保存交易记录
     */
    @RequestMapping(value = "/save_record", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData saveRecord(@RequestBody SubmitOrderInfo submitOrderInfo) {
        return detailService.saveRecord(submitOrderInfo);
    }

    /**
     * 处理支付宝回复
     */
    @RequestMapping(value = "/handle_reply", method = RequestMethod.POST)
    @ResponseBody
    public String handleReply(@ModelAttribute DirectPayResponseInfo directPayResponseInfo) {
        return detailService.handleReply(directPayResponseInfo);
    }

    /**
     * 余额支付
     */
    @RequestMapping(value = "/paied_by_money_bag", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData moneyBagPay(@RequestBody SubmitOrderInfo submitOrderInfo) {
        return detailService.changeAmount(submitOrderInfo);
    }


    /**
     * 处理退款
     */
    @RequestMapping(value = "/handle_refund", method = RequestMethod.POST)
    @ResponseBody
    public String refundReply(@ModelAttribute RefundResponseInfo refundResponseInfo) {
        return detailService.changeAmount(refundResponseInfo);
    }

    /**
     * 判断交易状态
     */
    @RequestMapping(value = "/get_detail_state", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getDetailState(@RequestParam("id") Long id) {
        try {
            boolean state = detailService.getDetailState(id);
            return new ResponseData(true, "判断交易状态成功", state);
        } catch (Exception e) {
            return new ResponseData(false, "系统问题判断失败", null);
        }
    }

    /**
     * 手机端获取请求参数
     */
    @RequestMapping(value = "/get_mobile_string", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getMobileRequestString(@RequestParam("subject") String subject, @RequestParam("body") String body,
                                               @RequestParam("price") String price, @RequestParam("id") Long id) {
        try{
          String url =   PayDemoActivity.pay(subject, body, price, id);
            return new ResponseData(true,"获取成功",url);
        }catch (Exception e){
            return new ResponseData(false,"获取失败",null);
        }
    }

    /**
     * mobile use wechat to pay
     */
    @RequestMapping(value = "/mobile_order", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData weChatPayByMobile(@RequestBody SubmitOrderInfo submitOrderInfo, HttpServletRequest request) {
        ResponseData responseData = detailService.saveRecord(submitOrderInfo);
        if (responseData.isSuccess()) {
            try {
                String prepayId = WeChatUtil.getprepayId(WeChatUtil.getBody(submitOrderInfo), ((Long) responseData.getObj()).toString(), (int) (long) submitOrderInfo.getAmount(), request.getRemoteAddr(), "APP");
                WeChatPayDirectPay weChatPayDirectPay = WeChatUtil.getMobileRequest(prepayId);
                return new ResponseData(responseData.isSuccess(), "创建订单成功", weChatPayDirectPay);
            } catch (UnknowOperationTypeException e) {
                return new ResponseData(false, e.getMessage(), null);
            }

        } else {
            return new ResponseData(responseData.isSuccess(), responseData.getMessage(), responseData.getObj());
        }
    }

    /**
     * 微信支付回调方法
     */
    @RequestMapping(value = "/wechat_notify_url", method = RequestMethod.POST)
    @ResponseBody
    public String weChatNotifyUrl(@RequestBody WeChatPayNotifyInfo weChatPayNotifyInfo) {
        return detailService.handlerWeChatPayment(weChatPayNotifyInfo);

    }

    /**
     * 打赏/转账
     */
    @RequestMapping(value = "/bag_direct_transfer")
    @ResponseBody
    public ResponseData directPayByMoneyBag(@RequestParam("currentUserId") Long currentUserId, @RequestParam("payToUserId")Long payToUserId, @RequestParam("amount")long amount ){
        return detailService.directPayByMoneyBag(currentUserId, payToUserId, amount);
    }
}
