/*
 * @(#)InvestorInfo.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.investor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * InvestorInfo
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class InvestorInfo implements Serializable {
    private Long investorId;
    private String investorName; // 人物名
    private int investorLevel;// 等级
    private String birthYear;// 出生年
    private String nativeProvince;  //籍贯省
    private String nativeDistrict;//籍贯市
    private String gender;// 性别
    private String status;  // 身份
    private List<String> firstFieldList; //行业
    private String achievement;// 成就
    private String investorIntro;//简介
    private String education;//教育
    private String eduExp;// 教育经历
    private String workExp;// 工作经历
    private String institutionName; // 机构名
    private String investorPosition;  // 投资人职位
    private String province;// 所在省
    private String city;//所在城市
    private String mobilePortraitUrl;// 手机图片
    private List<String> webPortraitUrlList;// web 图片
    private List<String> investorPhotoUrlList;//人物图片
    private Timestamp createTime;//记录新建时间
    private Timestamp lastUpdate;//记录更新时间
    private Long userId;//用户ID

    public InvestorInfo(Long investorId, String investorName, String investorPosition, int investorLevel,
                        String birthYear, String nativeProvince, String nativeDistrict, String education,
                        String gender, String institutionName, String province, String city, String achievement,
                        String investorIntro, List<String> firstFieldList, String eduExp, String workExp,
                        String mobilePortraitUrl, List<String> webPortraitUrlList, List<String> investorPhotoUrlList,
                        Timestamp createTime, Timestamp lastUpdate, Long userId, String status) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.investorPosition = investorPosition;
        this.investorLevel = investorLevel;
        this.birthYear = birthYear;
        this.nativeProvince = nativeProvince;
        this.nativeDistrict = nativeDistrict;
        this.education = education;
        this.gender = gender;

        this.institutionName = institutionName;
        this.province = province;
        this.city = city;
        this.achievement = achievement;

        this.investorIntro = investorIntro;
        this.investorPhotoUrlList = investorPhotoUrlList;
        this.firstFieldList = firstFieldList;

        this.eduExp = eduExp;
        this.workExp = workExp;

        this.mobilePortraitUrl = mobilePortraitUrl;
        this.webPortraitUrlList = webPortraitUrlList;
        this.investorPhotoUrlList = investorPhotoUrlList;

        this.createTime = createTime;
        this.lastUpdate = lastUpdate;
        this.userId = userId;
        this.status = status;
    }

    public InvestorInfo(Long investorId, String investorName, String investorPosition, int investorLevel,
                        String birthYear, String nativeProvince, String nativeDistrict, String education,
                        String gender, String institutionName, String province, String city, String achievement,
                        String investorIntro, List<String> firstFieldList, String eduExp, String workExp,
                        String mobilePortraitUrl, List<String> webPortraitUrlList, List<String> investorPhotoUrlList,
                        Timestamp createTime, Timestamp lastUpdate, String status) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.investorPosition = investorPosition;
        this.investorLevel = investorLevel;
        this.birthYear = birthYear;
        this.nativeProvince = nativeProvince;
        this.nativeDistrict = nativeDistrict;
        this.education = education;
        this.gender = gender;

        this.institutionName = institutionName;
        this.province = province;
        this.city = city;
        this.achievement = achievement;

        this.investorIntro = investorIntro;
        this.investorPhotoUrlList = investorPhotoUrlList;
        this.firstFieldList = firstFieldList;

        this.eduExp = eduExp;
        this.workExp = workExp;

        this.mobilePortraitUrl = mobilePortraitUrl;
        this.webPortraitUrlList = webPortraitUrlList;
        this.investorPhotoUrlList = investorPhotoUrlList;

        this.createTime = createTime;
        this.lastUpdate = lastUpdate;
        this.status = status;
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

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    public int getInvestorLevel() {
        return investorLevel;
    }

    public void setInvestorLevel(int investorLevel) {
        this.investorLevel = investorLevel;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
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


    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getInvestorIntro() {
        return investorIntro;
    }

    public void setInvestorIntro(String investorIntro) {
        this.investorIntro = investorIntro;
    }

    public List<String> getInvestorPhotoUrlList() {
        return investorPhotoUrlList;
    }

    public void setInvestorPhotoUrlList(List<String> investorPhotoUrlList) {
        this.investorPhotoUrlList = investorPhotoUrlList;
    }

    public List<String> getFirstFieldList() {
        return firstFieldList;
    }

    public void setFirstFieldList(List<String> firstFieldList) {
        this.firstFieldList = firstFieldList;
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

    public String getEduExp() {
        return eduExp;
    }

    public void setEduExp(String eduExp) {
        this.eduExp = eduExp;
    }

    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }


    public String getMobilePortraitUrl() {
        return mobilePortraitUrl;
    }

    public void setMobilePortraitUrl(String mobilePortraitUrl) {
        this.mobilePortraitUrl = mobilePortraitUrl;
    }

    public List<String> getWebPortraitUrlList() {
        return webPortraitUrlList;
    }

    public void setWebPortraitUrlList(List<String> webPortraitUrlList) {
        this.webPortraitUrlList = webPortraitUrlList;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InvestorInfo{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", investorLevel=" + investorLevel +
                ", birthYear='" + birthYear + '\'' +
                ", nativeProvince='" + nativeProvince + '\'' +
                ", nativeDistrict='" + nativeDistrict + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", firstFieldList=" + firstFieldList +
                ", achievement='" + achievement + '\'' +
                ", investorIntro='" + investorIntro + '\'' +
                ", education='" + education + '\'' +
                ", eduExp='" + eduExp + '\'' +
                ", workExp='" + workExp + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", investorPosition='" + investorPosition + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", mobilePortraitUrl='" + mobilePortraitUrl + '\'' +
                ", webPortraitUrlList=" + webPortraitUrlList +
                ", investorPhotoUrlList=" + investorPhotoUrlList +
                ", createTime=" + createTime +
                ", lastUpdate=" + lastUpdate +
                ", userId=" + userId +
                '}';
    }
}
