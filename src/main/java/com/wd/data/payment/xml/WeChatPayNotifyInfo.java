package com.wd.data.payment.xml;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 异步通知bean
 * Created by Zhipeng on 2016/5/31.
 */
@Root(name = "xml")
@XmlRootElement(name = "xml")
public class WeChatPayNotifyInfo {
    @Element(data = true)
    private String return_code;

    @Element(required = false,data = true)
    private String return_msg;

    @Element(required = false,data = true)
    private String appid;

    @Element(required = false,data = true)
    private String mch_id;

    @Element(required = false,data = true)
    private String device_info;

    @Element(required = false,data = true)
    private String nonce_str;

    @Element(required = false,data = true)
    private String sign;

    @Element(required = false,data = true)
    private String result_code;

    @Element(required = false,data = true)
    private String err_code;

    @Element(required = false,data = true)
    private String err_code_des;

    @Element(required = false,data = true)
    private String openid;

    @Element(required = false,data = true)
    private String is_subscribe;

    @Element(required = false,data = true)
    private String trade_type;

    @Element(required = false,data = true)
    private String bank_type;

    @Element(required = false,data = true)
    private int total_fee;

    @Element(required = false,data = true)
    private String fee_type;

    @Element(required = false,data = true)
    private int cash_fee;

    @Element(required = false,data = true)
    private String cash_fee_type;

    @Element(required = false,data = true)
    private int coupon_fee;

    @Element(required = false,data = true)
    private int coupon_count;

    @Element(required = false,data = true)
    private String transaction_id;

    @Element(required = false,data = true)
    private String out_trade_no;

    @Element(required = false,data = true)
    private String attch;

    @Element(required = false,data = true)
    private String time_end;

    public WeChatPayNotifyInfo() {
    }

    public WeChatPayNotifyInfo(String return_code, String return_msg, String appid, String mch_id, String device_info, String nonce_str, String sign, String result_code, String err_code, String err_code_des, String openid, String is_subscribe, String trade_type, String bank_type, int total_fee, String fee_type, int cash_fee, String cash_fee_type, int coupon_fee, int coupon_count, String transaction_id, String out_trade_no, String attch, String time_end) {
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
        this.openid = openid;
        this.is_subscribe = is_subscribe;
        this.trade_type = trade_type;
        this.bank_type = bank_type;
        this.total_fee = total_fee;
        this.fee_type = fee_type;
        this.cash_fee = cash_fee;
        this.cash_fee_type = cash_fee_type;
        this.coupon_fee = coupon_fee;
        this.coupon_count = coupon_count;
        this.transaction_id = transaction_id;
        this.out_trade_no = out_trade_no;
        this.attch = attch;
        this.time_end = time_end;
    }
    @XmlElement
    @XmlCDATA
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }
    @XmlElement
    @XmlCDATA
    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
    @XmlElement
    @XmlCDATA
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
    @XmlElement
    @XmlCDATA
    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }
    @XmlElement
    @XmlCDATA
    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }
    @XmlElement
    @XmlCDATA
    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }
    @XmlElement
    @XmlCDATA
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    @XmlElement
    @XmlCDATA
    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }
    @XmlElement
    @XmlCDATA
    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }
    @XmlElement
    @XmlCDATA
    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }
    @XmlElement
    @XmlCDATA
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
    @XmlElement
    @XmlCDATA
    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }
    @XmlElement
    @XmlCDATA
    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }
    @XmlElement
    @XmlCDATA
    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }
    @XmlElement
    @XmlCDATA
    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }
    @XmlElement
    @XmlCDATA
    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }
    @XmlElement
    @XmlCDATA
    public int getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
    }
    @XmlElement
    @XmlCDATA
    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }
    @XmlElement
    @XmlCDATA
    public int getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
    }
    @XmlElement
    @XmlCDATA
    public int getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
    }
    @XmlElement
    @XmlCDATA
    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
    @XmlElement
    @XmlCDATA
    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }
    @XmlElement
    @XmlCDATA
    public String getAttch() {
        return attch;
    }

    public void setAttch(String attch) {
        this.attch = attch;
    }
    @XmlElement
    @XmlCDATA
    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "WeChatPayNotifyInfo{" +
                "return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", device_info='" + device_info + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", result_code='" + result_code + '\'' +
                ", err_code='" + err_code + '\'' +
                ", err_code_des='" + err_code_des + '\'' +
                ", openid='" + openid + '\'' +
                ", is_subscribe='" + is_subscribe + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", bank_type='" + bank_type + '\'' +
                ", total_fee=" + total_fee +
                ", fee_type='" + fee_type + '\'' +
                ", cash_fee=" + cash_fee +
                ", cash_fee_type='" + cash_fee_type + '\'' +
                ", coupon_fee=" + coupon_fee +
                ", coupon_count=" + coupon_count +
                ", transaction_id='" + transaction_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", attch='" + attch + '\'' +
                ", time_end='" + time_end + '\'' +
                '}';
    }
}
