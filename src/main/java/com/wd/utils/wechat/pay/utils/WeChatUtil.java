package com.wd.utils.wechat.pay.utils;

import com.wd.common.PaymentOperationState;
import com.wd.data.payment.SubmitOrderInfo;
import com.wd.data.payment.xml.WeChatPay;
import com.wd.data.payment.xml.WeChatPayCallbackInfo;
import com.wd.data.payment.xml.WeChatPayDirectPay;
import com.wd.utils.BeanToMapUtils;
import com.wd.utils.UnknowOperationTypeException;
import com.wd.utils.XMLObjectParser;
import com.wd.utils.alipay.util.AlipayCore;
import com.wd.utils.alipay.util.AlipaySubmit;

import java.util.Map;

/**
 * Created by Zhipeng on 2016/6/1.
 */
public class WeChatUtil {
    public static String appid = "";
    public static String mch_id = "";
    public static String nonce_str = "";
    public static String uat_url = "http://www.touzidaren.cn:8080";
    public static String prod_url = "http://www.touzidaren.com:8080";
    public static String domain_url = uat_url;
    public static String notify_url = domain_url + "/web/payment/wechat_notify_url";
    public static String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static String key = "";

    public final static String SUCCESS_CODE = "SUCCESS";
    public final static String FAIL_CODE = "FAIL";
    public static WeChatPayCallbackInfo unifiedOrder(String body, String out_trade_no, int total_fee, String spbill_create_ip, String trade_type) {
        String currTime = TenpayUtil.getCurrTime();
        //8位日期
        String strTime = currTime.substring(8, currTime.length());
        //四位随机数
        String strRandom = TenpayUtil.buildRandom(4) + "";
        //10位序列号,可以自行调整。
        String strReq = strTime + strRandom;
        nonce_str = strReq;
        WeChatPay weChatPay = new WeChatPay(appid, mch_id, nonce_str, body, out_trade_no, total_fee, spbill_create_ip, notify_url, trade_type, "");
        String sign = getSignFromMap(weChatPay);
        weChatPay.setSign(sign);
        WeChatPayCallbackInfo weChatPayNotifyInfo = null;
        try {
            String s = XMLObjectParser.Object2XmlString(weChatPay);
            weChatPayNotifyInfo = GetWxOrderno.getPayObject(createOrderURL, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weChatPayNotifyInfo;
    }
    public static<T> String getSignFromMap(T t){
        Map<String, String> map = BeanToMapUtils.describe(t);
        Map<String, String> map2 = AlipayCore.paraFilter(map);
        String sign = AlipaySubmit.buildRequestMysign(map2, key);
        return sign;
    }
    public static String getprepayId(String body, String out_trade_no, int total_fee, String spbill_create_ip, String trade_type) {
        WeChatPayCallbackInfo weChatPayNotifyInfo = unifiedOrder(body, out_trade_no, total_fee, spbill_create_ip, trade_type);
        if (weChatPayNotifyInfo == null)
            return null;
        if (weChatPayNotifyInfo.getReturn_code().equals(SUCCESS_CODE) && weChatPayNotifyInfo.getResult_code().equals(SUCCESS_CODE)) {
            return weChatPayNotifyInfo.getPrepay_id();
        }else
            return null;
    }

    public static String getBody(SubmitOrderInfo submitOrderInfo)throws UnknowOperationTypeException{
        switch (submitOrderInfo.getOperationType()){
            case PaymentOperationState.operation_bag:
                return "充值";
            case PaymentOperationState.operation_advice:
                return "求指教";
            case PaymentOperationState.operation_deliery:
                return "项目投递";
            default:
                throw new UnknowOperationTypeException();
        }
    }

    public static WeChatPayDirectPay getMobileRequest(String prepayid){
        String currTime = TenpayUtil.getCurrTime();
        //8位日期
        String strTime = currTime.substring(8, currTime.length());
        //四位随机数
        String strRandom = TenpayUtil.buildRandom(4) + "";
        //10位序列号,可以自行调整。
        String strReq = strTime + strRandom;
        nonce_str = strReq;
        Long timestamp = System.currentTimeMillis();
        Long timestamp10 = timestamp/1000;
        String s = timestamp10.toString();
        WeChatPayDirectPay weChatPayDirectPay = new WeChatPayDirectPay(appid,mch_id,prepayid,"Sign=WXPay",nonce_str,s);
        String sign = getSignFromMap(weChatPayDirectPay);
        weChatPayDirectPay.setSign(sign);
        return weChatPayDirectPay;
    }
}
