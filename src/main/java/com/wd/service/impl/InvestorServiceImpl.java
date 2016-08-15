/*
 * @(#)InvestorServiceImpl.java, 2015/11/18.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service.impl;

import com.wd.common.UserType;
import com.wd.dao.*;
import com.wd.data.*;
import com.wd.data.investor.*;
import com.wd.domain.*;
import com.wd.repositories.InvestorRepository;
import com.wd.service.InvestorService;
import com.wd.utils.*;
import com.qiniu.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * InvestorServiceImpl
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
@Service
public class InvestorServiceImpl implements InvestorService {
    Logger logger = Logger.getLogger(InvestorServiceImpl.class);

    private int CACHE_INVESTOR_ACCESS_EXPIRE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.expire_after_access"));
    private int CACHE_INVESTOR_WRITE_EXPIRE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.expire_after_write"));
    private int CACHE_INVESTOR_MAX_SIZE = Integer.parseInt(ConfigUtils.getProperty("cache.investor.maxsize"));

    @Autowired
    private InvestorInfoDao investorInfoDao;
    @Autowired
    private InstitutionInfoDao institutionInfoDao;

    @Autowired
    private InvestorRepository investorRepository;


    @Override
    public ResponseData getInvestorById(Long investorId) {
        if (investorId == null) {
            logger.error(" method parameter investorId is null");
            return new ResponseData(false, "investorId is null", null);

        } else if (investorId == 0) {
            logger.error("method parameter investorId == 0");
            return new ResponseData(false, "investorId == 0", null);
        }

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);
            InvestorInfo info = parseInvestorEntity(entity);

            return new ResponseData(true, "get investor info success", info);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "investor with id: " + investorId + " not exists", null);
        }
    }

    /**
     * 解析Investor Entity
     *
     * @param entity
     * @return
     */
    private InvestorInfo parseInvestorEntity(InvestorInfoEntity entity) {
        Long investorId = entity.getInvestorId();
        String investorName = entity.getInvestorName();
        Long userId = entity.getUserInfoEntity().getUserId();
        String investorPosition = entity.getInvestorPosition();
        String birthYear = entity.getBirthYear();
        String nativeProvince = entity.getNativeProvince();
        String nativeDistrict = entity.getNativeDistrict();
        String education = entity.getEducation();
        String gender = entity.getGender();

        String institutionName = entity.getInstitutionName();
        int investorLevel = entity.getInvestorLevel();


        String province = entity.getProvince();
        String city = entity.getCity();

        String achievement = entity.getAchievement();
        String investorIntro = entity.getInvestorIntro();

        String eduExp = entity.getEduExp();
        String workExp = entity.getWorkExp();

        String mobilePortraitUrl = entity.getMobilePortrait();
        List<String> webPortraitUrl = getPhotoUrlList(entity.getWebPortrait());
        List<String> investorPhotoUrlList = getPhotoUrlList(entity.getInvestorPhoto());


        String firstFields = entity.getFirstFields();
        List<String> fieldList = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(firstFields)) {
            String[] firstFieldArray = firstFields.split("\\|");

            if (firstFieldArray[0].length() == 0)
                fieldList = new ArrayList<>();
            else
                fieldList = Arrays.asList(firstFieldArray);
        }

        Timestamp createTime = entity.getCreateTime();
        Timestamp lastUpdate = entity.getUpdateTime();
        String status = entity.getStatus();
        InvestorInfo investorInfo = new InvestorInfo(investorId, investorName, investorPosition, investorLevel, birthYear,
                nativeProvince, nativeDistrict, education, gender, institutionName,  province, city, achievement,
                investorIntro,  fieldList,  eduExp, workExp,  mobilePortraitUrl, webPortraitUrl,
                investorPhotoUrlList, createTime, lastUpdate, userId, status);

        return investorInfo;
    }

    @Override
    @Transactional
    public ResponseData uploadInvestorBasicInfo(InvestorBasicInfo info) {
        logger.info(info);
        long investorId = info.getInvestorId();

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);
            if(entity ==null)
                return new ResponseData(false,"此inverstorId不存在", null);
            if (!StringUtils.isNullOrEmpty(info.getInvestorName()))
                entity.setInvestorName(info.getInvestorName());
            if (!StringUtils.isNullOrEmpty(info.getBirthYear()))
                entity.setBirthYear(info.getBirthYear());
            if (!StringUtils.isNullOrEmpty(info.getNativeProvince()))
                entity.setNativeProvince(info.getNativeProvince());
            if (!StringUtils.isNullOrEmpty(info.getNativeDistrict()))
                entity.setNativeDistrict(info.getNativeDistrict());
            if (!StringUtils.isNullOrEmpty(info.getGender()))
                entity.setGender(info.getGender());
            if (!StringUtils.isNullOrEmpty(info.getEducation()))
                entity.setEducation(info.getEducation());
            if (!StringUtils.isNullOrEmpty(info.getInstitutionName()))
                entity.setInstitutionName(info.getInstitutionName());
            if (!StringUtils.isNullOrEmpty(info.getInvestorPosition()))
                entity.setInvestorPosition(info.getInvestorPosition());
            if (!StringUtils.isNullOrEmpty(info.getProvince()))
                entity.setProvince(info.getProvince());
            if (!StringUtils.isNullOrEmpty(info.getCity()))
                entity.setCity(info.getCity());
            if (!StringUtils.isNullOrEmpty(info.getMobilePortraitUrl()))
                entity.setMobilePortrait(info.getMobilePortraitUrl());

            List<String> webPortraitUrlList = info.getWebPortraitUrl();
            StringBuilder sb = new StringBuilder();
            if (webPortraitUrlList != null) {
                for (int i = 0; i < webPortraitUrlList.size(); i++) {
                    if (i == 0)
                        sb.append(webPortraitUrlList.get(0));
                    else
                        sb.append("|" + webPortraitUrlList.get(1));
                }
                entity.setWebPortrait(sb.toString());
            }
            sb = new StringBuilder();
            if (info.getFirstFieldList() != null) {
                sb = new StringBuilder();
                for (int i = 0; i < info.getFirstFieldList().size(); i++) {
                    if (i == 0)
                        sb.append(info.getFirstFieldList().get(i));
                    else
                        sb.append("|" + info.getFirstFieldList().get(i));
                }

                entity.setFirstFields(sb.toString());
            }

            // 上传基本信息、投资人照片、投资阶段、投资领域
            investorInfoDao.save(entity);
            logger.info("save basic info success, investorId = " + investorId);
            return new ResponseData(true, "success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "fail", null);
        }
    }

    @Override
    @Transactional
    public ResponseData uploadInvestorIntro(InvestorIntro intro) {
        long investorId = intro.getInvestorId();
        logger.info("upload investor intro begin, investorId = " + investorId);
        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);
            if (!StringUtils.isNullOrEmpty(intro.getInvestorIntro()))
            entity.setInvestorIntro(intro.getInvestorIntro());
            if (!StringUtils.isNullOrEmpty(intro.getAchievement()))
            entity.setAchievement(intro.getAchievement());
            if (!StringUtils.isNullOrEmpty(intro.getEduExp()))
            entity.setEduExp(intro.getEduExp());
            if (!StringUtils.isNullOrEmpty(intro.getWorkExp()))
            entity.setWorkExp(intro.getWorkExp());
            // 上传投资人介绍信息
            investorInfoDao.save(entity);
            logger.info("save investor intro success, investorId = " + investorId);
            return new ResponseData(true, "success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "fail", null);
        }
    }


    @Override
    public ResponseData uploadInvestorPhoto(Long investorId, List<String> urlList) {
        if (investorId == null || investorId <= 0 || urlList == null || urlList.size() == 0) {
            String msg = "investorId = " + investorId + "; url = " + urlList;
            logger.error(msg);
            return new ResponseData(false, msg, null);
        }

        try {
            InvestorInfoEntity entity = investorInfoDao.findByInvestorId(investorId);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < urlList.size(); i++) {
                if (i == 0)
                    sb.append(urlList.get(i));
                else
                    sb.append("|" + urlList.get(i));
            }
            entity.setInvestorPhoto(sb.toString());
            investorInfoDao.save(entity);

            return new ResponseData(true, "upload investor photo success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "upload investor photo fail", null);
        }
    }

    /**
     *
     */
    @Override
    public ResponseData getAllInvestorList() {
        try {
            List<InvestorInfoEntity> investorInfoEntities = investorInfoDao.findAll();
            List<InvestorInfo> investorInfos = parseInvestorEntities(investorInfoEntities);

            return new ResponseData(true, "get investor info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get investor info List exists", null);
        }
    }


    @Override
    public ResponseData getListByName(String name) {
        try {

            name = "%" + name + "%";
            List<InvestorInfoEntity> investorInfoEntities1 = investorInfoDao.findByInvestorNameLike(name);
            List<InvestorInfo> investorInfos = parseInvestorEntities(investorInfoEntities1);
            return new ResponseData(true, "get search List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get search List fail", null);
        }
    }

    @Override
    public ResponseData getFullSearch(String institutionName, String institutionMember, String position, int page, int size) {
        try {
            updateES();

            if (StringUtils.isNullOrEmpty(institutionName)) {
                institutionName = "?";
            }

            if (StringUtils.isNullOrEmpty(institutionMember)) {
                institutionMember = "?";
            }
            if (StringUtils.isNullOrEmpty(position)) {
                position = "?";
            }
            Iterable<Long> ids =
                    EntityDocumentConvertor
                            .getInvestorIds(investorRepository.findByInvestorNameAndInstitutionNameAndInvestorPosition(institutionName, institutionMember, position, new PageRequest(page, size)));
            Iterable<InvestorInfoEntity> InvestorInfoEntities = investorInfoDao.findAll(ids);

            List<InvestorInfo> investorInfos = parseInvestorEntities(InvestorInfoEntities);
            return new ResponseData(true, "", investorInfos);
        } catch (Exception e) {
            return new ResponseData(false, "", null);
        }
    }

    @Override
    public ResponseData getByFirstField(String firstField, Byte position, int page, int size) {
        try {

            firstField = "%" + firstField + "%";
            Page<InvestorInfoEntity> investorInfoEntities1 = investorInfoDao.findByLevelTypeAndFirstFieldsLike(position, firstField, new PageRequest(page, size));
            List<InvestorInfo> investorInfos = parseInvestorEntities(investorInfoEntities1);
            return new ResponseData(true, "get search List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get search List fail", null);
        }
    }

    @Override
    public ResponseData getInvestorLevel(Long investorId) {
        try {

            InvestorInfoEntity investorInfoEntities1 = investorInfoDao.findOne(investorId);
            return new ResponseData(true, "get Investor Level success", investorInfoEntities1.getInvestorLevel());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Investor Level fail", null);
        }
    }

    private void updateES() {
        investorRepository.deleteAll();
        investorRepository.save(EntityDocumentConvertor.renderInvestor(investorInfoDao.findAll()));
    }

    private List<AdvertismentInfo> parseInstitutionToAdInfo(List<InstitutionInfoEntity> instituionList) {
        List<AdvertismentInfo> infos = new ArrayList<>();
        Long id;
        String name;
        String img;
        for (InstitutionInfoEntity e : instituionList) {
            id = e.getInstitutionId();
            name = e.getInstitutionName();
            img = e.getMobileLogo();
            infos.add(new AdvertismentInfo(id, name, UserType.INSTITUTION, img));

        }
        return infos;
    }

    private List<AdvertismentInfo> parseInvestorEntitiesToAdInfo(List<InvestorInfoEntity> investorInfoEntities) {
        List<AdvertismentInfo> infos = new ArrayList<>();
        Long id;
        String name;
        String img;
        for (InvestorInfoEntity e : investorInfoEntities) {
            id = e.getInvestorId();
            name = e.getInvestorName();
            img = e.getMobilePortrait();
            infos.add(new AdvertismentInfo(id, name, UserType.INVESTOR, img));
        }
        return infos;
    }

    private List<InvestorInfo> parseInvestorEntities(Iterable<InvestorInfoEntity> investorInfoEntities) {
        List<InvestorInfo> investorInfos = new ArrayList<>();
        InvestorInfo investorInfo;
        for (InvestorInfoEntity investorInfoEntity : investorInfoEntities) {
            investorInfo = parseInvestorEntity(investorInfoEntity);
            investorInfos.add(investorInfo);
        }
        return investorInfos;
    }

    /**
     * 获取投资人照片
     *
     * @param urlStr
     * @return
     */
    private List<String> getPhotoUrlList(String urlStr) {
        if (urlStr == null || urlStr.length() == 0) {
            logger.error("gwo et investor photo url list error, method parameter entity is null");
            return null;
        }
        String[] urlArray = urlStr.split("\\|");

        List<String> urlList;
        if (urlArray.length == 1 && urlArray[0].length() == 0)
            urlList = new ArrayList<>();
        else
            urlList = Arrays.asList(urlArray);

        return urlList;
    }

}
