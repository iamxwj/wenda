package com.wd.data.payment.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 微信支付请求
 * Created by Zhipeng on 2016/5/30.
 */
@Root(name="xml")
public class WeChatPay {
    @Element
    private String appid;
    @Element
    private String mch_id;
    @Element
    private String nonce_str;
    @Element
    private String body;
    @Element
    private String out_trade_no;
    @Element
    private int total_fee;
    @Element
    private String spbill_create_ip;
    @Element
    private String notify_url;
    @Element
    private String trade_type;
    @Element
    private String sign;
    public WeChatPay() {
    }

    public WeChatPay(String appid, String mch_id, String nonce_str, String body, String out_trade_no, int total_fee,
                     String spbill_create_ip, String notify_url, String trade_type, String sign) {
        this.appid = appid;
        this.mch_id = mch_id;
        this.nonce_str = nonce_str;
        this.body = body;
        this.out_trade_no = out_trade_no;
        this.total_fee = total_fee;
        this.spbill_create_ip = spbill_create_ip;
        this.notify_url = notify_url;
        this.trade_type = trade_type;
        this.sign = sign;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }


    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "WebChatPay{" +
                "appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", body='" + body + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", total_fee='" + total_fee + '\'' +
                ", spbill_create_ip='" + spbill_create_ip + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
