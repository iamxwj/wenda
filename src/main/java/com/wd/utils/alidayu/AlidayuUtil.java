package com.wd.utils.alidayu;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.util.Random;

/**
 * @author Zhipeng
 * @date 2016/7/21.
 */
public class AlidayuUtil {
    public static String URL = "http://gw.api.taobao.com/router/rest";
    public static String appkey = "23416289";
    public static String secret = "1562a4c153ad4f1e36808442503255a9";

    public static int generateRandomNumber() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        return n;
    }

    public static AlibabaAliqinFcSmsNumSendResponse sendSms(int code, String phone) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(AlidayuUtil.URL, AlidayuUtil.appkey, AlidayuUtil.secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName("身份验证");
        req.setSmsParamString("{\"code\":\"" + code +
                "\",\"product\":\"投资达人\"}");
        req.setRecNum(phone);
        req.setSmsTemplateCode("SMS_12600385");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        rsp = client.execute(req);
        return rsp;
    }


}
