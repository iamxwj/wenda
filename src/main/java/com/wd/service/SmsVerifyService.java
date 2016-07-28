package com.wd.service;

import com.wd.data.ResponseData;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
public interface SmsVerifyService {
    public ResponseData sendSms(Long phone);

    public ResponseData verifySms(Long smsId, int code, Long phone);
}
