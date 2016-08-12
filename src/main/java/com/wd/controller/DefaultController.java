/*
 * @(#)DefaultController.java, 2015/11/5.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.controller;

import com.wd.data.*;
import com.wd.domain.InvestMemberLevelEntity;
import com.wd.service.DefaultService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * DefaultController
 *
 * @author chenbin
 * @date 2015/11/5
 */
@Controller
@RequestMapping("/web")
public class DefaultController {
    Logger logger = Logger.getLogger(DefaultController.class);

    @Autowired
    private DefaultService defaultService;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        request.getSession();

        return "index";
    }

    /**
     * 获取投资阶段列表
     * @return
     */
    @RequestMapping("/phase_list")
    @ResponseBody
    public List<PhaseInfo> getPhaseList(HttpServletRequest request) {
        List<PhaseInfo> phaseInfoList = defaultService.getPhaseList();
        ServletContext context = request.getServletContext();
        System.out.println("context path: " + context.getContextPath());
        
        return phaseInfoList;

    }

    /**
     * 获取投资领域列表
     * @return
     */
    @RequestMapping(value = "/field_list")
    @ResponseBody
    public List<Map<String, Object>> getFieldList() {
        logger.info("method begin");
        return defaultService.getFieldList();
    }



    @RequestMapping(value = "/invest_member_level")
    @ResponseBody
    public List<Map<String, Object>> getMemberLevelList() {
        return defaultService.getMemberLevelList();
    }

    /**
     * 获取省份列表
     * @return
     */
    @RequestMapping("/provinces_list")
    @ResponseBody
    public List<ProvinceInfo> getProvinceList() {
        List<ProvinceInfo> provinceInfoList = defaultService.getProvincesList();

        return provinceInfoList;
    }

    /**
     * 根据省份ID获取城市列表
     * @param provinceId
     * @return
     */
    @RequestMapping("/cities_list")
    @ResponseBody
    public List<CityInfo> getCityList(@RequestParam("provinceId") Integer provinceId) {
        return defaultService.getCitiesListByProvinceId(provinceId);
    }

    /**
     * 获取省份列表
     * @return
     */
    @RequestMapping("/province_list")
    @ResponseBody
    public List<ProvinceInfo> getProvincesList() {
        List<ProvinceInfo> provinceInfoList = defaultService.getProvinceList();

        return provinceInfoList;
    }

    /**
     * 根据省份ID获取城市列表
     * @param provinceId
     * @return
     */
    @RequestMapping("/city_list")
    @ResponseBody
    public List<CityInfo> getCitiesList(@RequestParam("provinceId") Integer provinceId) {
        return defaultService.getCityListByProvinceId(provinceId);
    }

    /**
     * 获取职位level
     */
    @RequestMapping("/member_level")
    @ResponseBody
    public InvestMemberLevelEntity getCityList(@RequestParam("memberId") int  memberId) {
        return defaultService.getMemberLevel(memberId);
    }
}
