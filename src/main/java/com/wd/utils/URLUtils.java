/*
 * @(#)URLUtils.java, 2015/11/11.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.utils;

/**
 * URLUtils
 *
 * @author chenbin
 * @date 2015/11/11
 */
public class URLUtils {
    private static String imageServerUrl = ConfigUtils.getProperty("server.image");

    public static String getZimgUrl(String md5) {
        return imageServerUrl + md5 + "?p=0";
    }

}
