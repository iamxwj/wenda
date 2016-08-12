/*
 * @(#)InstitutionInfo.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

import com.wd.data.investor.InvestorShortList;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * InstitutionInfo
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class InstitutionInfo implements Serializable {
    private Long institutionId;
    private String institutionName; // 机构名
    private String institutionIntro; // 机构简介
    private String achievement; //成就
    private int institutionLevel;// 等级
    private String foundYear;// 成立时间
    private Double fundNumber;// 资金规模
    private String fundUnit;// 资金单位
    private String staffSize;// 员工规模
    private String status; //地位
    private String business; // 业务

    private List<String> firstFields;//行业

    private String province;//总部省
    private String city;//总部城市
    private String address;//总部地址
    private String webLogo;// web 图片
    private String mobileLogo;// 手机图片

    private Timestamp createTime;//创建时间
    private Timestamp updateTime;//更新时间
    private Long userId;// 用户ID
    private List<String> investorName;// 高管名字列表
    private List<InvestorShortList> investorShortLists;// 高管简略列表

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public List<String> getInvestorName() {
        return investorName;
    }

    public void setInvestorName(List<String> investorName) {
        this.investorName = investorName;
    }

    public List<InvestorShortList> getInvestorShortLists() {
        return investorShortLists;
    }

    public void setInvestorShortLists(List<InvestorShortList> investorShortLists) {
        this.investorShortLists = investorShortLists;
    }

    public InstitutionInfo() {
    }


    public InstitutionInfo(Long institutionId, String name, String institutionIntro, String achievements, int level,
                           String year, Double fundNumber, String fundUnit, String staffSize,
                           List<String> firstFields, String province,  String city,
                           String address,  String webLogo, String mobileLogo, Timestamp createTime,
                           Timestamp updateTime, Long userId, List<String> investorName,
                           List<InvestorShortList> investorShortLists, String status, String business) {
        this.institutionId = institutionId;
        this.institutionName = name;
        this.achievement = achievements;
        this.institutionLevel = level;
        this.foundYear = year;
        this.institutionIntro = institutionIntro;
        this.fundNumber = fundNumber;
        this.fundUnit = fundUnit;
        this.staffSize = staffSize;
        this.firstFields = firstFields;
        this.province = province;
        this.city = city;
        this.address = address;
        this.webLogo = webLogo;
        this.mobileLogo = mobileLogo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
        this.investorName = investorName;
        this.investorShortLists = investorShortLists;
        this.status = status;
        this.business = business;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionIntro() {
        return institutionIntro;
    }

    public void setInstitutionIntro(String institutionIntro) {
        this.institutionIntro = institutionIntro;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public int getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(int institutionLevel) {
        this.institutionLevel = institutionLevel;
    }

    public String getFoundYear() {
        return foundYear;
    }

    public void setFoundYear(String foundYear) {
        this.foundYear = foundYear;
    }

    public Double getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(Double fundNumber) {
        this.fundNumber = fundNumber;
    }

    public String getFundUnit() {
        return fundUnit;
    }

    public void setFundUnit(String fundUnit) {
        this.fundUnit = fundUnit;
    }

    public List<String> getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(List<String> firstFields) {
        this.firstFields = firstFields;
    }



    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    public String getMobileLogo() {
        return mobileLogo;
    }

    public void setMobileLogo(String mobileLogo) {
        this.mobileLogo = mobileLogo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
