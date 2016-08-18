/*
 * @(#)AuthorityController.java, 2015/11/3.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.data.UserLoginInfo;
import com.wd.data.UserRegisterInfo;
import com.wd.domain.SmsVerifyEntity;
import com.wd.service.CaptchaService;
import com.wd.service.SmsVerifyService;
import com.wd.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthorityController
 *
 * @author chenbin
 * @date 2015/11/3
 */
@Controller
@RequestMapping("/web/auth")
public class UserController {
    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;
    
    @Autowired
    private SmsVerifyService smsVerifyService;
    
   /* @Autowired
    private CaptchaService captchaService;*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData login(HttpServletRequest request, HttpServletResponse response, @RequestBody UserLoginInfo userLoginInfo) {
    	if(userLoginInfo==null){
    		return new ResponseData(false, "请输入相应的信息", null);
    	}
    	return userInfoService.validateUserPass(request, response, userLoginInfo);
    }

    /**
     * 注册请求
     * @param request
     * @param info
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData register(@RequestBody SmsVerifyEntity smsVerifyEntity,HttpServletRequest request, @RequestBody UserRegisterInfo info) {
        logger.info("用户注册");
        String sessionId = request.getSession().getId();
        // 验证输入的验证码
        /*boolean catpchaResult = captchaService.validateCaptcha(info.getCaptchaStr(), request);

        if(!catpchaResult) {
            ResponseData status = new ResponseData(false, ResponseData.CAPTCHA_ERROR, null);
            return status;
        }*/

        /* 短信验证码验证未添加 */
        ResponseData verifySms = smsVerifyService.verifySms(smsVerifyEntity.getSmsId(),smsVerifyEntity.getCode() , smsVerifyEntity.getPhone());
        if(!verifySms.isResult()){
        	return verifySms;
        }
        logger.info("开始校验数据");
        ResponseData status = userInfoService.addUser(request, info);
        return status;
    }

    /**
     * 获取验证码
     * @param request
     * @param response
     * @throws IOException
     */
   /* @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        captchaService.setCaptcha(request, response);
    }*/

    /**
     * 用户名是否存在
     * @param username
     * @return
     */
    @RequestMapping(value = "/user_exists", method = RequestMethod.GET)
    @ResponseBody
    public boolean userExists(@RequestParam("username") String username) {
        return userInfoService.existsUser(username);
    }

    /**
     * 手机号码是否存在
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/mobile_exists", method = RequestMethod.GET)
    @ResponseBody
    public boolean mobileExists(@RequestParam("mobile") String mobile) {
        return userInfoService.existsMobile(mobile);
    }

    /**
     * 邮箱是否存在
     * @param email
     * @return
     */
    @RequestMapping(value = "email_exists", method = RequestMethod.GET)
    @ResponseBody
    public boolean emailExists(@RequestParam("email") String email) {
        return userInfoService.existsEmail(email);
    }


    /**
     * 验证码是否合法
     * @param captchaStr
     * @param request
     * @return
     */
   /* @RequestMapping("/validate_captcha")
    @ResponseBody
    public boolean validateCaptcha(@RequestParam("captcha_str") String captchaStr, HttpServletRequest request) {
        boolean result = captchaService.validateCaptcha(captchaStr, request);

        return result;
    }*/


    /**
     * 登出操作
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.changeSessionId();

        return "auth/login";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "modify_password", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyPassword(@RequestBody UserLoginInfo userLoginInfo){
        return userInfoService.modifyPassword(userLoginInfo);
    }
    /**
     * 修改email
     */
    @RequestMapping(value = "modify_email", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyEmail(@RequestBody UserLoginInfo userLoginInfo){
        return userInfoService.modifyEmail(userLoginInfo);
    }
    /**
     * 修改phone
     */
    @RequestMapping(value = "modify_phone", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData modifyPhone(@RequestBody UserLoginInfo userLoginInfo){
        return userInfoService.modifyPhone(userLoginInfo);
    }


    /**
     * 直接修改密码（通过验证码后）
     * @param userLoginInfo
     * @return
     */
    @RequestMapping(value = "/direct_change_pass", method = RequestMethod.POST)
    @ResponseBody
    ResponseData modifyPasswordByVerify(@RequestBody UserLoginInfo userLoginInfo){
        return userInfoService.modifyPasswordByVerify(userLoginInfo);
    }
    
}
