/*
 * @(#)ZimgResult.java, 2016/2/29.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.zimg;

import com.wd.utils.ConfigUtils;

/**
 * ZimgResult
 *
 * @author chenbin
 * @date 2016/2/29
 */
public class ZimgResult {
    public static String zimgUrl = ConfigUtils.getProperty("server.image");

    private boolean ret;
    private ZimgInfo info;
    private ZimgError error;

    public ZimgError getError() {
        return error;
    }

    public void setError(ZimgError error) {
        this.error = error;
    }

    public String getImageUrl() {
        if (this.isRet()) {
            return zimgUrl + this.info.getMd5() + "?p=0";
        }
        return "";
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ZimgInfo getInfo() {
        return info;
    }

    public void setInfo(ZimgInfo info) {
        this.info = info;
    }

}

