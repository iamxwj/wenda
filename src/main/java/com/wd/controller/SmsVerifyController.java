package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.service.SmsVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
@Controller
@RequestMapping("/web/sms")
public class SmsVerifyController {
    @Autowired
    private SmsVerifyService verifyService;
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData sendSms(@RequestParam("phone") Long phone){
        return verifyService.sendSms( phone);
    }
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData verifySms(@RequestParam("smsId")Long smsId,
                                  @RequestParam("code")int code,
                                  @RequestParam("phone")Long phone){
        return verifyService.verifySms(smsId, code, phone);
    }
}
