/*
 * @(#)InvestorBasicInfoForm.java, 2015/11/27.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.investor;

import java.util.List;

/**
 * InvestorBasicInfo
 *
 * @author chenbin
 * @date 2015/11/27
 */
public class InvestorBasicInfo {
    private Long investorId;
    private String investorName; // 名字
    private String birthYear; //出生年份
    private String nativeProvince; // 籍贯省
    private String nativeDistrict; // 籍贯市
    private String gender;//性别
    private String education;// 教育
    private String institutionName;// 机构名
    private String investorPosition;// 职位
    private String status;  // 投资类型
    private List<String> firstFieldList;// 行业
    private String mobilePortraitUrl; // 移动端头像
    private List<String> webPortraitUrl; // web端头像
    private String province;// 所在省
    private String city;// 所在市
    private Byte levelType;// 职位等级

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte getLevelType() {
        return levelType;
    }

    public void setLevelType(Byte levelType) {
        this.levelType = levelType;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getNativeProvince() {
        return nativeProvince;
    }

    public void setNativeProvince(String nativeProvince) {
        this.nativeProvince = nativeProvince;
    }

    public String getNativeDistrict() {
        return nativeDistrict;
    }

    public void setNativeDistrict(String nativeDistrict) {
        this.nativeDistrict = nativeDistrict;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobilePortraitUrl() {
        return mobilePortraitUrl;
    }

    public void setMobilePortraitUrl(String mobilePortraitUrl) {
        this.mobilePortraitUrl = mobilePortraitUrl;
    }

    public List<String> getWebPortraitUrl() {
        return webPortraitUrl;
    }

    public void setWebPortraitUrl(List<String> webPortraitUrl) {
        this.webPortraitUrl = webPortraitUrl;
    }


    public List<String> getFirstFieldList() {
        return firstFieldList;
    }

    public void setFirstFieldList(List<String> firstFieldList) {
        this.firstFieldList = firstFieldList;
    }

}
