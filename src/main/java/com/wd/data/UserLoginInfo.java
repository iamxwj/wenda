/*
 * @(#)UserInfo.java, 2016/2/17.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

/**
 * UserLoginInfo
 *
 * @author chenbin
 * @date 2016/2/17
 */
public class UserLoginInfo {
    private String username;
    private String newPassword;
    private String password;
    private String email;
    private String phone;


    public ValidResult validateAllFields() {
        if(username == null || username.length() == 0)
            return new ValidResult(false, "username = " + username);
        if(password == null || password.length() == 0)
            return new ValidResult(false, "password = " + password);
        return new ValidResult(true, toString());
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

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

}
