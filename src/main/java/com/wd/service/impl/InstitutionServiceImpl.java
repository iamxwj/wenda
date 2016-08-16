/*
 * @(#)InstitutionServiceImpl.java, 2015/11/11.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiniu.util.StringUtils;
import com.wd.dao.InstitutionInfoDao;
import com.wd.repositories.InstitutionRepository;
import com.wd.data.ResponseData;
import com.wd.data.institution.InstitutionBasicInfo;
import com.wd.data.institution.InstitutionIdName;
import com.wd.data.institution.InstitutionInfo;
import com.wd.data.investor.InvestorShortList;
import com.wd.domain.InstitutionInfoEntity;
import com.wd.domain.InvestorInfoEntity;
import com.wd.domain.es.InstitutionDocument;
import com.wd.service.InstitutionService;
import com.wd.utils.EntityDocumentConvertor;

/**
 * InstitutionServiceImpl
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
@Service
public class InstitutionServiceImpl implements InstitutionService {

    private Logger logger = Logger.getLogger(InstitutionServiceImpl.class);

    @Autowired
    private InstitutionInfoDao institutionInfoDao;

    @Autowired
    private InstitutionRepository institutionRepository;

    /**
     * 透过机构ID获取投资机构信息
     *
     * @param institutionId
     * @return
     */
    @Override
    public ResponseData getInstitutionById(Long institutionId) {
        if (institutionId == null) {
            logger.error("method parameter institutionId is null");
            return new ResponseData(false, "institutionId is null", null);
        }
        if (institutionId == 0) {
            logger.error("method parameter institutionId == 0");
            return new ResponseData(false, "institutionId == 0", null);
        }
        logger.info("institutionId == " + institutionId);


        InstitutionInfoEntity entity = institutionInfoDao.findByInstitutionId(institutionId);
        if (entity == null)
            return new ResponseData(false, "get institution info fail", null);

        InstitutionInfo info = parseInstitutionEntity(entity);
        return new ResponseData(true, "get institution info success", info);
    }

    /**
     * 解析机构Entity
     *
     * @param entity
     * @return
     */
    private InstitutionInfo parseInstitutionEntity(InstitutionInfoEntity entity) {
        Long institutionId = entity.getInstitutionId();
        String name = entity.getInstitutionName();
        String institutionIntro = entity.getInstitutionIntro();
        String achievements = entity.getAchievement();
        int level = entity.getInstitutionLevel();
        Long userId = entity.getUserInfoEntity().getUserId();
        String year = entity.getFundYear();
        Double fundNumber = entity.getFundNumber();
        String fundUnit = entity.getFundUnit();
        String staffSize = entity.getStaffSize();
        String status = entity.getStatus();
        String business = entity.getBusiness();
        List<String> firstFields = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(entity.getFirstFields())) {
            String[] firstFieldArray = entity.getFirstFields().split("\\|");

            if (firstFieldArray[0].length() == 0)
                firstFields = new ArrayList<>();
            else
                firstFields = Arrays.asList(firstFieldArray);
        }


        String province = entity.getProvince();
        String city = entity.getCity();
        String address = entity.getAddress();
        List<String> investorNames = renderInvestorsToStringList(entity.getMemberEntityList());
        List<InvestorShortList> investorShortList = renderInvestorsToShortLists(entity.getMemberEntityList());

        String webLogo = entity.getWebLogo();
        String mobileLogo = entity.getMobileLogo();

        Timestamp createTime = entity.getCreateTime();
        Timestamp updateTime = entity.getUpdateTime();

        InstitutionInfo info = new InstitutionInfo(institutionId, name, institutionIntro, achievements,level, year,
                fundNumber, fundUnit, staffSize, firstFields, province, city, address, webLogo, mobileLogo, createTime,
                updateTime, userId, investorNames, investorShortList, status, business);

        return info;
    }

    private List<InvestorShortList> renderInvestorsToShortLists(List<InvestorInfoEntity> memberEntityList) {
        List<InvestorShortList> investorShortList = new ArrayList<>();
        for (InvestorInfoEntity i : memberEntityList) {
            investorShortList.add(renderInvestorsToShortList(i));
        }
        return investorShortList;
    }

    private InvestorShortList renderInvestorsToShortList(InvestorInfoEntity i) {
        return new InvestorShortList(i.getInvestorName(), i.getMobilePortrait(), i.getInvestorPosition());
    }


    private List<String> renderInvestorsToStringList(List<InvestorInfoEntity> memberEntityList) {
        List<String> names = new ArrayList<>();

        for (InvestorInfoEntity i : memberEntityList) {
            names.add(i.getInvestorName());
        }
        return names;
    }



    @Override
    public ResponseData getInstitutionIdNameList(String nameLike) {
        if (nameLike == null || nameLike.length() == 0) {
            String logStr = "method parameter nameLike == " + nameLike;
            logger.error(logStr);
            return new ResponseData(false, logStr, null);
        }

        List<InstitutionInfoEntity> institutionInfoEntityList = institutionInfoDao.findByInstitutionNameLike(nameLike);

        List<InstitutionIdName> institutionIdNameList = new ArrayList<>();
        if (institutionInfoEntityList == null || institutionInfoEntityList.size() == 0) {
            return new ResponseData(true, "result is empty", institutionIdNameList);
        }

        for (InstitutionInfoEntity entity : institutionInfoEntityList) {
            long institutionId = entity.getInstitutionId();
            String institutionName = entity.getInstitutionName();

            InstitutionIdName institutionIdName = new InstitutionIdName(institutionId, institutionName);
            institutionIdNameList.add(institutionIdName);
        }
        return new ResponseData(true, "get list success", institutionIdNameList);
    }

    @Override
    @Transactional
    public ResponseData uploadInstitutionBasicInfo(InstitutionBasicInfo info) {
        if (info == null) {
            String logInfo = "method parameter info == " + info;
            logger.error(logInfo);
            return new ResponseData(false, logInfo, null);
        }
//        ValidResult valid = info.validateAllFields();
//        logger.debug("field validate result : " + valid.getMsg());
//        if (!valid.isValid()) {
//            String msg = valid.getMsg();
//            return new ResponseData(false, msg, null);
//        }

        long institutionId = info.getInstitutionId();
        try {
            InstitutionInfoEntity entity = institutionInfoDao.findByInstitutionId(institutionId);
            if (!StringUtils.isNullOrEmpty(info.getInstitutionName()))
                entity.setInstitutionName(info.getInstitutionName());
            if (!StringUtils.isNullOrEmpty(info.getFundYear()))
                entity.setFundYear(info.getFundYear());
            if (info.getFundNumber() != null)
                entity.setFundNumber(info.getFundNumber());
            if (!StringUtils.isNullOrEmpty(info.getFundUnit()))
                entity.setFundUnit(info.getFundUnit());
            if (!StringUtils.isNullOrEmpty(info.getStaffSize()))
                entity.setStaffSize(info.getStaffSize());


            StringBuilder sb2 = new StringBuilder();
            if (info.getFirstFields() != null) {
                for (int i = 0; i < info.getFirstFields().size(); i++) {
                    if (i == 0)
                        sb2.append(info.getFirstFields().get(i));
                    else
                        sb2.append("|" + info.getFirstFields().get(i));
                }
                entity.setFirstFields(sb2.toString());
            }


            if (!StringUtils.isNullOrEmpty(info.getProvince()))
                entity.setProvince(info.getProvince());
            if (!StringUtils.isNullOrEmpty(info.getCity()))
                entity.setCity(info.getCity());
            if (!StringUtils.isNullOrEmpty(info.getAddress()))
                entity.setAddress(info.getAddress());
            if (!StringUtils.isNullOrEmpty(info.getAchievement()))
                entity.setAchievement(info.getAchievement());
            if (!StringUtils.isNullOrEmpty(info.getIntro()))
                entity.setInstitutionIntro(info.getIntro());
            if (!StringUtils.isNullOrEmpty(info.getWebLogo()))
                entity.setWebLogo(info.getWebLogo());
            if (!StringUtils.isNullOrEmpty(info.getMobileLogo()))
                entity.setMobileLogo(info.getMobileLogo());

            institutionInfoDao.save(entity);

            logger.info("upload institution basic info success, institutionId = " + institutionId);
            return new ResponseData(true, "upload institution basic info success", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "upload institution basic info fail", null);
        }
    }

//    @Override
//    public ResponseData uploadInsitutionPhoto(Long institutionId, List<String> url) {
//        InstitutionInfoEntity entity = institutionInfoDao.findOne(institutionId);
//
//        if (entity != null) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < url.size(); i++) {
//                if (i == 0)
//                    sb.append(url.get(i));
//                else
//                    sb.append("|" + url.get(i));
//            }
//            entity.setInstitutionPhoto(sb.toString());
//
//            institutionInfoDao.save(entity);
//            return new ResponseData(true, "success", null);
//        }
//        return new ResponseData(false, "fail", null);
//    }

    @Override
    public ResponseData getAllInstitutionList() {
        try {
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findAll();
            List<InstitutionInfo> investorInfos = parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get institution info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get institution info List exists", null);
        }
    }

    private List<InstitutionInfo> parseInvestorEntities(Iterable<InstitutionInfoEntity> institutionInfoEntities) {
        List<InstitutionInfo> institutionInfos = new ArrayList<>();
        InstitutionInfo institutionInfo;
        for (InstitutionInfoEntity in : institutionInfoEntities) {
            institutionInfo = parseInstitutionEntity(in);
            institutionInfos.add(institutionInfo);
        }
        return institutionInfos;
    }

    @Override
    public ResponseData getListByNameList(String name) {
        try {
            name = "%" + name + "%";
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByInstitutionNameLike(name);
            List<InstitutionInfo> investorInfos = parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get institution info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get institution info List exists", null);
        }
    }

    @Override
    public ResponseData getFullSearch(String institutionName, String institutionMember, int page, int size) {
        try {
            updateES();

            if (StringUtils.isNullOrEmpty(institutionName)) {
                institutionName = "?";
            }

            if (StringUtils.isNullOrEmpty(institutionMember)) {
                institutionMember = "?";
            }
            Iterable<Long> ids = EntityDocumentConvertor.getInstitutionIds(institutionRepository.findByInstitutionNameAndInstitutionMemberNames(institutionName, institutionMember, new PageRequest(page, size)));
            Iterable<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findAll(ids);

            List<InstitutionInfo> institutionInfos = parseInvestorEntities(institutionInfoEntities);
            return new ResponseData(true, "", institutionInfos);
        } catch (Exception e) {
            return new ResponseData(false, "", null);
        }
    }

    @Override
    public ResponseData getFirstField(String firstField, int page, int size) {
        try {
            firstField = "%" + firstField + "%";
            Page<InstitutionInfoEntity> institutionInfoEntities = institutionInfoDao.findByFirstFieldsLike(firstField, new PageRequest(page, size));
            List<InstitutionInfo> investorInfos = parseInvestorEntities(institutionInfoEntities);

            return new ResponseData(true, "get institution info List success", investorInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get institution info List exists", null);
        }
    }

    @Override
    public ResponseData getInstitutionLevel(Long institutionId) {
        try {
            InstitutionInfoEntity institutionInfoEntities = institutionInfoDao.findByInstitutionId(institutionId);
            return new ResponseData(true, "get Institution Level success", institutionInfoEntities.getInstitutionLevel());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "get Institution Level fail", null);
        }
    }

    private void updateES() {
        institutionRepository.deleteAll();
        Iterable<InstitutionDocument> documents = EntityDocumentConvertor.renderInstitutions(institutionInfoDao.findAll());
        institutionRepository.save(documents);
    }
}
