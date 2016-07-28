
/*
 * @(#)ZimgController.java, 2016/3/1.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.service.ZimgService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * ZimgController
 *
 * @author chenbin
 * @date 2016/3/1
 */
@Controller
@RequestMapping(value = "/web")
public class ZimgController {
    private Logger logger = Logger.getLogger(ZimgController.class);

    @Autowired
    private ZimgService zimgService;

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadImage(MultipartHttpServletRequest request) {
        logger.debug("method begin");
        // 会话验证
        return zimgService.uploadImgToZimg(request);
    }


    @RequestMapping(value = "/download_url", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getDownloadAddress(@RequestParam("fileName") String fileName) {

        // 会话验证
        return zimgService.getDownloadAddress(fileName);
    }
}
