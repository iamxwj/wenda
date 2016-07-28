/*
 * @(#)CaptchaService.java, 2015/11/9.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CaptchaService
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public interface CaptchaService {

    /**
     * 向客户端返回验证码图片，并将验证码字符串写入session中
     * @param request
     * @param response
     */
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response);

    public boolean validateCaptcha(String captchaStr, HttpServletRequest request);

//    /**
//     * 获取验证码的字节码表示
//     * @param captchaId:用户会话ID
//     * @return
//     */
//    byte[] getCaptchaImageByteArray(String captchaId);
//
//    /**
//     *
//     * @param captchaId：用户会话ID
//     * @param inputCaptcha：用户输入的验证码字符串
//     * @return
//     */
//    boolean validateCaptcha(String captchaId, String inputCaptcha);
}
