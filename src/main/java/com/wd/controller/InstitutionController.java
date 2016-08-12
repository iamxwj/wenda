/*
 * @(#)InstitutionController.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.data.institution.InstitutionBasicInfo;
import com.wd.service.InstitutionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * InstitutionController
 *
 * @author chenbin
 * @date 2015/11/4
 */
@Controller
@RequestMapping("/web/institution")
public class InstitutionController {
    Logger logger = Logger.getLogger(InstitutionController.class);

    @Autowired
    private InstitutionService institutionService;



    /**
     * 机构详细信息
     *
     * @param institutionId
     */
    @RequestMapping(value = "/institution_info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionInfo(@RequestParam("id") Long institutionId) {
        logger.debug(" institutionId = " + institutionId);

        return institutionService.getInstitutionById(institutionId);
    }

    /**
     * 机构个人中心
     */
    @RequestMapping(value = "/institution_center", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData institutionCenter(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 用户尚未登录
        if (session == null)
            return null;

        Long institutionId = (Long) session.getAttribute("institutionId");
        return institutionService.getInstitutionById(institutionId);
    }

    /**
     * 上传基本信息
     *
     * @param info
     */
    @RequestMapping(value = "/institution_basic_info", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInstitutionBasicInfo(@RequestBody InstitutionBasicInfo info) {
        logger.error("basic info = " + info);
//        HttpSession session = request.getSession(false);
//        if(session == null) {
//            logger.error("user not login");
//            return new ResponseData(false, ResponseData.NOT_LOGIN, null);
//        }

        return institutionService.uploadInstitutionBasicInfo(info);
    }


    @RequestMapping(value = "/institution_name_like", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionIdNameList(String nameLike) {
        logger.debug(" method begin");
        return institutionService.getInstitutionIdNameList(nameLike);
    }

    /**
     * 获取全部列表
     */
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorListAll() {
        logger.debug("method begin");
        return institutionService.getAllInstitutionList();

    }


    @RequestMapping(value = "/search_by_name", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getListByNameList(@RequestParam("name") String name) {
        return institutionService.getListByNameList(name);
    }

    @RequestMapping(value = "/full_search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getFullSearch(@RequestParam("institutionName") String institutionName,
                                      @RequestParam("institutionMember") String institutionMember,
                                      @RequestParam("page") int page,
                                      @RequestParam("size") int size) {
        return institutionService.getFullSearch(institutionName, institutionMember, page, size);
    }

    @RequestMapping(value = "/first_field", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getFirstField(@RequestParam("firstField") String firstField,
                                      @RequestParam("page") int page,
                                      @RequestParam("size") int size){
        return institutionService.getFirstField(firstField, page, size);
    }

    /**
     * 机构评级
     *
     * @param institutionId
     */
    @RequestMapping(value = "/institution_Level", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInstitutionLevel(@RequestParam("id") Long institutionId) {
        logger.debug(" institutionId = " + institutionId);

        return institutionService.getInstitutionLevel(institutionId);
    }
}
