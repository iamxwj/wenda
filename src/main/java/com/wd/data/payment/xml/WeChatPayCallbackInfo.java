package com.wd.data.payment.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Zhipeng on 2016/6/2.
 */
@Root(name = "xml")
public class WeChatPayCallbackInfo {
    @Element
    private String return_code;

    @Element(required = false)
    private String return_msg;

    @Element(required = false)
    private String appid;

    @Element(required = false)
    private String mch_id;

    @Element(required = false)
    private String device_info;

    @Element(required = false)
    private String nonce_str;

    @Element(required = false)
    private String sign;

    @Element(required = false)
    private String result_code;

    @Element(required = false)
    private String err_code;

    @Element(required = false)
    private String err_code_des;

    @Element(required = false)
    private String trade_type;

    @Element(required = false)
    private String prepay_id;

    public WeChatPayCallbackInfo() {
    }

    public WeChatPayCallbackInfo(String return_code, String return_msg, String appid, String mch_id, String device_info, String nonce_str, String sign, String result_code, String err_code, String err_code_des, String trade_type, String prepay_id) {
        this.return_code = return_code;
        this.return_msg = return_msg;
        this.appid = appid;
        this.mch_id = mch_id;
        this.device_info = device_info;
        this.nonce_str = nonce_str;
        this.sign = sign;
        this.result_code = result_code;
        this.err_code = err_code;
        this.err_code_des = err_code_des;
        this.trade_type = trade_type;
        this.prepay_id = prepay_id;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
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

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }
}
