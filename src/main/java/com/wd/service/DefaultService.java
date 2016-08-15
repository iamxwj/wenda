/*
 * @(#)UniversalService.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service;

import com.wd.data.CityInfo;
import com.wd.data.PhaseInfo;
import com.wd.data.ProvinceInfo;
import com.wd.domain.InvestMemberLevelEntity;

import java.util.List;
import java.util.Map;

/**
 * DefaultService
 *
 * @author chenbin
 * @date 2015/12/4
 */
public interface DefaultService {
    /**
     * 获取省份列表,按省份ID排序
     * @return
     */
    List<ProvinceInfo> getProvinceList();

    /**
     * 根据省份ID获取城市列表
     * @param provinceId
     * @return
     */
    List<CityInfo> getCityListByProvinceId(int provinceId);

    /**
     * 获取省份列表,按省份ID排序
     * @return
     */
    List<ProvinceInfo> getProvincesList();

    /**
     * 根据省份ID获取城市列表
     * @param provinceId
     * @return
     */
    List<CityInfo> getCitiesListByProvinceId(int provinceId);

    /**
     * 获取投资阶段列表
     * @return
     */
    List<PhaseInfo> getPhaseList();

    /**
     * 获取投资领域列表
     * @return
     */
    List<Map<String, Object>> getFieldList();

    /**
     * 获取投资机构成员
     * @return
     */
    List<Map<String, Object>> getMemberLevelList();

    /**
     * 获取职位level
     */
    InvestMemberLevelEntity getMemberLevel(int memberId);

}
