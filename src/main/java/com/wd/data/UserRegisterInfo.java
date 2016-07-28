/*
 * @(#)UserInfoForm.java, 2015/11/28.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

/**
 * UserRegisterInfo
 *
 * @author chenbin
 * @date 2015/11/28
 */
public class UserRegisterInfo {
    private String username;
    private String password;
    /** 1 ==> investor
     *  2 ==> institution
     *  3 ==> project
    */
    private byte userType;
    private String email;
    private String mobile;
    private String captchaStr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptchaStr() {
        return captchaStr;
    }

    public void setCaptchaStr(String captchaStr) {
        this.captchaStr = captchaStr;
    }

    @Override
    public String toString() {
        return "UserRegisterInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", captchaStr='" + captchaStr + '\'' +
                '}';
    }
}
