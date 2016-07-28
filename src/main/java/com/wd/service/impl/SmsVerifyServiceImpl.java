package com.wd.service.impl;

import com.wd.dao.SmsVerifyDao;
import com.wd.data.ResponseData;
import com.wd.domain.SmsVerifyEntity;
import com.wd.service.SmsVerifyService;
import com.wd.utils.JSONUtil;
import com.wd.utils.alidayu.AliResponse;
import com.wd.utils.alidayu.AlidayuUtil;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;

import static com.wd.common.ResponseMessage.ERROR_MSG;
import static com.wd.common.ResponseMessage.SUCCESS_MSG;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
@Service
public class SmsVerifyServiceImpl implements SmsVerifyService {


    @Autowired
    private SmsVerifyDao smsVerifyDao;

    @Override
    public ResponseData sendSms(Long phone) {
        try {
            int code = AlidayuUtil.generateRandomNumber();
            SmsVerifyEntity smsVerifyEntity = new SmsVerifyEntity(phone, code);

            AlibabaAliqinFcSmsNumSendResponse alibabaAliqinFcSmsNumSendResponse = AlidayuUtil.sendSms(code, String.valueOf(phone));
            String jsonBody = alibabaAliqinFcSmsNumSendResponse.getBody();
            AliResponse result = null;
            try {
                result = JSONUtil.JSONStringToObject(jsonBody, AliResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            if(result.getAlibabaAliqinFcSmsNumSendResponse().getResult().getErrCode().equals("15")){
//                return new ResponseData(false,"操作过于频繁", null);
//            }else if(result.getAlibabaAliqinFcSmsNumSendResponse().getResult().getErrCode().equals("0")){
            smsVerifyEntity = smsVerifyDao.save(smsVerifyEntity);
            return new ResponseData(true, SUCCESS_MSG, smsVerifyEntity);
//            }else{
//                return new ResponseData(false,ERROR_MSG,null);
//            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, ERROR_MSG, null);
        }
    }

    @Override
    public ResponseData verifySms(Long smsId, int code, Long phone) {
        try {
            SmsVerifyEntity smsVerifyEntity = smsVerifyDao.findOne(smsId);
            if (!phone.equals(smsVerifyEntity.getPhone())) {
                return new ResponseData(false, "短信验证的手机号不正确", null);
            }
            Timestamp oldTime = smsVerifyEntity.getCreateDate();
            long old = oldTime.getTime();
            long cur = System.currentTimeMillis();
            long diff = cur - old;
            if (diff <= 5 * 60 * 1000) {
                if (code == smsVerifyEntity.getCode())
                    return new ResponseData(true, SUCCESS_MSG, null);
                else
                    return new ResponseData(false, "验证码错误", null);
            } else {
                return new ResponseData(false, "短信验证码过期请重新申请", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "短信验证错误", null);
        }
    }
}
