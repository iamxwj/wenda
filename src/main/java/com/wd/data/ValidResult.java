/*
 * @(#)ValidResult.java, 2016/2/25.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

/**
 * ValidResult
 *
 * @author chenbin
 * @date 2016/2/25
 */
public class ValidResult {
    private boolean valid;
    private String msg;

    public ValidResult(boolean valid, String msg) {
        this.valid = valid;
        this.msg = msg;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
