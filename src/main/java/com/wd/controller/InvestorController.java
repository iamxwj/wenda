/*
 * @(#)InvestorController.java, 2015/11/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.controller;

import com.wd.data.ResponseData;
import com.wd.data.investor.InvestorBasicInfo;
import com.wd.data.investor.InvestorIntro;
import com.wd.service.InvestorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * InvestorController
 *
 * @author chenbin
 * @date 2015/11/4
 */
@Controller
@RequestMapping("/web/investor")
public class InvestorController {
    Logger logger = Logger.getLogger(InvestorController.class);

    @Autowired
    private InvestorService investorService;

    /**
     * 获取全部列表
     */
    @RequestMapping(value = "/list_all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorListAll() {
        logger.debug("method begin");
        return investorService.getAllInvestorList();
    }


    /**
     * 投资者信息
     *
     * @param investorId
     * @return
     */
    @RequestMapping(value = "/investor_info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorInfo(Long investorId) {
        logger.debug("investorId = " + investorId);
        return investorService.getInvestorById(investorId);
    }

    /**
     * 投资者个人中心
     *
     * @param investorId
     * @return
     */
    @RequestMapping(value = "investor_center", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorCenter(@RequestParam("investorId") Long investorId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
            return new ResponseData(false, "No Session", null);
        return investorService.getInvestorById(investorId);
    }

    /**
     * 上传投资者基本信息
     *
     * @param investorBasicInfo
     */
    @RequestMapping(value = "/investor_basic_info", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInvestorBasicInfo(@RequestBody InvestorBasicInfo investorBasicInfo) {
        logger.debug(" investorBasicInfo: " + investorBasicInfo);
        // session验证
        return investorService.uploadInvestorBasicInfo(investorBasicInfo);
    }

    /**
     * 上传投资人介绍信息
     *
     * @param investorIntro
     * @return
     */
    @RequestMapping(value = "/investor_intro", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData uploadInvestorIntro(@RequestBody InvestorIntro investorIntro) {
        logger.info("investorIntro: " + investorIntro);
        return investorService.uploadInvestorIntro(investorIntro);
    }

    @RequestMapping(value = "/search_by_name", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByName(@RequestParam("name") String name) {
        return investorService.getListByName(name);
    }

    @RequestMapping(value = "/full_search", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getFullSearch(@RequestParam("investorName") String investorName,
                                      @RequestParam("institutionMember") String institutionName,
                                      @RequestParam("position") String position,
                                      @RequestParam("page") int page,
                                      @RequestParam("size") int size) {
        return investorService.getFullSearch(investorName, institutionName, position, page, size);
    }

    /**
     *
     * @param firstField
     * @param position
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/get_by_firstField", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getByFirstField(@RequestParam("firstField") String firstField,
                                        @RequestParam("position") Byte position,
                                        @RequestParam("page") int page,
                                        @RequestParam("size") int size){
        return investorService.getByFirstField(firstField,position, page,size);
    }

    /**
     * 人物信息
     *
     * @param investorId
     * @return
     */
    @RequestMapping(value = "/investor_level", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData investorLevel(@RequestParam("id") Long investorId) {
        logger.debug("investorId = " + investorId);
        return investorService.getInvestorLevel(investorId);
    }


    @RequestMapping(value = "/list_by_tag", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getInvestorListByTag(@RequestParam("tag") String tag) {
        return investorService.getInvestorListByTag(tag);
    }
}
