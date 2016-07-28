/*
 * @(#)ZimgService.java, 2016/2/29.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service;

import com.wd.data.ResponseData;

import javax.servlet.http.HttpServletRequest;

/**
 * ZimgService
 *
 * @author chenbin
 * @date 2016/2/29
 */
public interface ZimgService {
    /**
     * 上传图片到Zimg服务器
     *
     * @param request
     * @return
     */
    public ResponseData uploadImgToZimg(HttpServletRequest request);



    /**
     * 获取下载地址
     */
    public ResponseData getDownloadAddress(String fileName);


    /**
     * 删除文档
     */
}
