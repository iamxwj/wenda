package com.wd.data.payment.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Zhipeng on 2016/6/2.
 */
@Root(name = "xml")
public class WeChatPayDirectPay {
    @Element
    private String appid;

    @Element
    private String partnerid;

    @Element
    private String prepayid;

    @Element(name = "package")
    private String packages;

    @Element
    private String noncestr;

    @Element
    private String timestamp;

    @Element
    private String sign;

    public WeChatPayDirectPay() {
    }

    public WeChatPayDirectPay(String appid, String partnerid, String prepayid, String packages, String noncestr, String timestamp) {
        this.appid = appid;
        this.partnerid = partnerid;
        this.prepayid = prepayid;
        this.packages = packages;
        this.noncestr = noncestr;
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
