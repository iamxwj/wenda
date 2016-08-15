/*
 * @(#)UniversalServiceImpl.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service.impl;

import com.wd.dao.*;
import com.wd.data.*;
import com.wd.domain.*;
import com.wd.service.DefaultService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DefaultServiceImpl
 *
 * @author chenbin
 * @date 2015/12/4
 */
@Service
public class DefaultServiceImpl implements DefaultService {
    Logger logger = Logger.getLogger(DefaultServiceImpl.class);
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private InvestFieldDao investFieldDao;
    @Autowired
    private InvestPhaseDao investPhaseDao;
    @Autowired
    private InvestMemberLevelDao memberLevelDao;
    @Autowired
    private ProvincesDao provincesDao;


    @Override
    public List<ProvinceInfo> getProvinceList() {
        Iterable<ProvinceEntity> provinceEntityIterable = provinceDao.findAll();

        List<ProvinceInfo> provinceList = new ArrayList<>();
        for(ProvinceEntity entity : provinceEntityIterable) {
            ProvinceInfo info = new ProvinceInfo(entity.getProvinceId(), entity.getProvinceName());
            provinceList.add(info);
        }
        logger.info(" get province list success");
        return provinceList;
    }

    @Override
    public List<CityInfo> getCityListByProvinceId(int provinceId) {
        ProvinceEntity provinceEntity = provinceDao.findOne(provinceId);
        List<CityEntity> cityEntityList = provinceEntity.getCityEntityList();

        List<CityInfo> cityInfoList = new ArrayList<>();
        for(CityEntity entity : cityEntityList) {
            CityInfo info = new CityInfo(entity.getCityId(), entity.getCityName());
            cityInfoList.add(info);
        }
        logger.info("get city list by province id success");
        return cityInfoList;
    }

    /**
     * 获取省份列表,按省份ID排序
     *
     * @return
     */
    @Override
    public List<ProvinceInfo> getProvincesList() {
        Iterable<ProvincesEntity> provinceEntityIterable = provincesDao.findAll();

        List<ProvinceInfo> provinceList = new ArrayList<>();
        for(ProvincesEntity entity : provinceEntityIterable) {
            ProvinceInfo info = new ProvinceInfo(entity.getProvinceId(), entity.getProvinceName());
            provinceList.add(info);
        }
        logger.info(" get province list success");
        return provinceList;
    }

    /**
     * 根据省份ID获取城市列表
     *
     * @param provinceId
     * @return
     */
    @Override
    public List<CityInfo> getCitiesListByProvinceId(int provinceId) {
        ProvincesEntity provinceEntity = provincesDao.findOne(provinceId);
        List<CitiesEntity> cityEntityList = provinceEntity.getCityEntityList();

        List<CityInfo> cityInfoList = new ArrayList<>();
        for(CitiesEntity entity : cityEntityList) {
            CityInfo info = new CityInfo(entity.getCityId(), entity.getCityName());
            cityInfoList.add(info);
        }
        logger.info("get city list by province id success");
        return cityInfoList;
    }

    @Override
    public List<PhaseInfo> getPhaseList() {
        Iterable<InvestPhaseEntity> phaseEntityIterable = investPhaseDao.findAll();

        List<PhaseInfo> phaseList = new ArrayList<>();
        for(InvestPhaseEntity entity : phaseEntityIterable) {
            PhaseInfo info = new PhaseInfo(entity.getPhaseId(), entity.getPhaseName());
            phaseList.add(info);
        }
        logger.info(" get phase list success");
        return phaseList;
    }

    @Override
    public List<Map<String, Object>> getFieldList() {
        Iterable<InvestFieldEntity> fieldEntityIterable = investFieldDao.findAll();
        Map<String, List<FieldInfo>> fieldMap = new HashMap<>();

        for(InvestFieldEntity entity : fieldEntityIterable) {
            String fieldType = entity.getFieldType();
            List<FieldInfo> infoList = fieldMap.get(fieldType);
            if(infoList == null) {
                infoList = new ArrayList<>();
            }
            infoList.add(new FieldInfo(entity.getFieldId(), entity.getFieldName()));
            fieldMap.put(fieldType, infoList);
        }

        List<Map<String, Object>> result = new ArrayList<>();

        for(String key : fieldMap.keySet()) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", key);
            item.put("item", fieldMap.get(key));

            result.add(item);
        }
        logger.info(" get field list success");
        return result;
    }

    @Override
    public List<Map<String, Object>> getMemberLevelList() {
        Iterable<InvestMemberLevelEntity> memberLevelEntityList = memberLevelDao.findAll();

        Map<String, List<String>> ret = new HashMap<>();
        for(InvestMemberLevelEntity entity : memberLevelEntityList) {
            String level = entity.getLevel();
            String position = entity.getPosition();

            if(ret.keySet().contains(level)) {
                List<String> list = ret.get(level);
                list.add(position);
            } else {
                List<String> list = new ArrayList<>();
                list.add(position);
                ret.put(level, list);
            }
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for(String key : ret.keySet()) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", key);
            List<Map<String,String>> items = new ArrayList<Map<String,String>>();
            for(String v : ret.get(key)){
            	Map<String,String> m = new HashMap<String,String>();
            	m.put("name", v);
            	items.add(m);
            }
            item.put("items", items);
            result.add(item);

        }
        return result;
    }

    /**
     * 获取职位level
     *
     * @param memberId
     */
    @Override
    public InvestMemberLevelEntity getMemberLevel(int memberId) {
        InvestMemberLevelEntity investMemberLevelEntity =  memberLevelDao.findOne(memberId);
        return investMemberLevelEntity;
    }
}
