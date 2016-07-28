package com.wd.data.payment.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 异步通知返回server参数
 * Created by Zhipeng on 2016/5/31.
 */
@Root(name = "xml")
@XmlRootElement(name="xml")
public class WeChatPayNotifyReturnInfo {
    @Element(data = true)
    private String return_code;

    @Element(required = false,data = true)
    private String return_msg;

    public WeChatPayNotifyReturnInfo() {
    }

    public WeChatPayNotifyReturnInfo(String return_code, String return_msg) {
        this.return_code = return_code;
        this.return_msg = return_msg;
    }
    @XmlElement
    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }
    @XmlElement
    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }
}
