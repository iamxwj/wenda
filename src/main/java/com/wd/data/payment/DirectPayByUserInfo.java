package com.wd.data.payment;

import com.wd.utils.alipay.config.AlipayConfig;

/**
 * to calculate the sign
 * 为了计算签名
 * Created by Zhipeng on 2016/5/11.
 */
public class DirectPayByUserInfo {
    /**
     * 基本参数
     */
    private String service;
    private String partner;
    private String _input_charset;
    private String sign_type;
    private String sign;
    private String nofity_url;
    private String return_url;
    /**
     * 业务参数
     */
    private String out_trade_no;
    private String subject;
    private String payment_type;
    private double total_fee;
    private String seller_id;
    private String seller_email;
    private String seller_account_name;
    private String buyer_id;
    private String buyer_email;
    private String buyer_account_name;
//    private double price;
//    private int quantity;
    private String body;
    private String show_url;
    private String paymethod;
    private String enable_paymethod;

    public DirectPayByUserInfo() {
        this._input_charset = AlipayConfig.input_charset;
        this.partner = AlipayConfig.partner;
        this.seller_email = AlipayConfig.seller_email;
        this.nofity_url = AlipayConfig.direct_pay_notify_url;
        this.return_url = AlipayConfig.return_url;
        this._input_charset = AlipayConfig.input_charset;
        this.sign_type = AlipayConfig.sign_type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String get_input_charset() {
        return _input_charset;
    }

    public void set_input_charset(String _input_charset) {
        this._input_charset = _input_charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNofity_url() {
        return nofity_url;
    }

    public void setNofity_url(String nofity_url) {
        this.nofity_url = nofity_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public double getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(double total_fee) {
        this.total_fee = total_fee;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getSeller_account_name() {
        return seller_account_name;
    }

    public void setSeller_account_name(String seller_account_name) {
        this.seller_account_name = seller_account_name;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_email() {
        return buyer_email;
    }

    public void setBuyer_email(String buyer_email) {
        this.buyer_email = buyer_email;
    }

    public String getBuyer_account_name() {
        return buyer_account_name;
    }

    public void setBuyer_account_name(String buyer_account_name) {
        this.buyer_account_name = buyer_account_name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShow_url() {
        return show_url;
    }

    public void setShow_url(String show_url) {
        this.show_url = show_url;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public String getEnable_paymethod() {
        return enable_paymethod;
    }

    public void setEnable_paymethod(String enable_paymethod) {
        this.enable_paymethod = enable_paymethod;
    }

    @Override
    public String toString() {
        return "DirectPayByUserInfo{" +
                "service='" + service + '\'' +
                ", partner='" + partner + '\'' +
                ", _input_charset='" + _input_charset + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", sign='" + sign + '\'' +
                ", nofity_url='" + nofity_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", subject='" + subject + '\'' +
                ", payment_type='" + payment_type + '\'' +
                ", total_fee=" + total_fee +
                ", seller_id='" + seller_id + '\'' +
                ", seller_email='" + seller_email + '\'' +
                ", seller_account_name='" + seller_account_name + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", buyer_email='" + buyer_email + '\'' +
                ", buyer_account_name='" + buyer_account_name + '\'' +
                ", body='" + body + '\'' +
                ", show_url='" + show_url + '\'' +
                ", paymethod='" + paymethod + '\'' +
                ", enable_paymethod='" + enable_paymethod + '\'' +
                '}';
    }
}
