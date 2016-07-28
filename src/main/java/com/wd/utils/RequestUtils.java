/*
 * @(#)RequestUtils.java, 2015/11/3.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestUtils
 *
 * @author chenbin
 * @date 2015/11/3
 */
public class RequestUtils {
    /**
     * 获取客户端的真实IP地址
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && "unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个IP值，第一个IP才是真实IP
            int index = ip.indexOf(", ");
            if(index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
