/*
 * @(#)LoginError.java, 2015/11/3.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.common;

/**
 * LoginError
 *
 * @author chenbin
 * @date 2015/11/3
 */
public enum LoginError {
    PASSWORD_ERROR("用户名或者密码错误"),

    PASSWORD_ERROR_TOO_MUCH("密码错误次数过多，该账号已经被封禁，请等待10分钟后再试"),

    ACCOUNT_DISABLE("账号已经失效，请联系管理员");

    LoginError(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

}
