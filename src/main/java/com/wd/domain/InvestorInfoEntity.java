/*
 * @(#)InvestorInfoEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * InvestorInfoEntity
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
@Entity
@Table(name = "investor_info", schema = "", catalog = "djt")
public class InvestorInfoEntity {
    private Long investorId;
    private String status;
    private String firstFields;
    private String investorName;
    private String investorPosition;
    private Byte investorLevel;
    private String birthYear;
    private String nativeProvince;
    private String nativeDistrict;
    private String education;
    private String gender;
    private String eduExp;
    private String workExp;
    private String institutionName;
    private Long institutionId;
    private String province;
    private String city;
    private String achievement;
    private String investorIntro;
    private String webPortrait;
    private String mobilePortrait;
    private String investorPhoto;
    private Byte levelType;// 人物职位等级

    // 投资项目列表
//    private List<InvestorCaseEntity> investorCaseEntityList;
    private UserInfoEntity userInfoEntity;

    private Timestamp createTime;
    private Timestamp updateTime;

    /**
     * 默认构造方法设置各个字段的默认值
     */
    public InvestorInfoEntity() {
        investorName = "未命名";

        investorLevel = 0;
        birthYear = "0000";
        nativeProvince = "未知";
        nativeDistrict = "未知";
        gender = "未知";

        firstFields = "未知";

        investorIntro = "未知";
        achievement = "未知";
        education = "未知";
        eduExp = "未知";
        workExp = "未知";

        institutionName = "未知";
        investorPosition = "未知";
        institutionId = 0L;

        province = "未知";
        city = "未知";
        webPortrait = "";
        mobilePortrait = "http://123.56.184.92:4869/9d43184eefdf27ed129bfeff6a5b8c99?p=0";
        investorPhoto = "";
        levelType = (byte)1;
    }

    @Id
    @Column(name = "investor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    @Column
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 单向OneToOne, FetchType.LAZY
     *
     * @return
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    @Basic
    @Column(name = "investor_name")
    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }


    @Basic
    @Column(name = "investor_position")
    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    @Basic
    @Column(name = "investor_level")
    public Byte getInvestorLevel() {
        return investorLevel;
    }

    public void setInvestorLevel(Byte investorLevel) {
        this.investorLevel = investorLevel;
    }


    @Basic
    @Column(name = "birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    @Basic
    @Column(name = "native_province")
    public String getNativeProvince() {
        return nativeProvince;
    }

    public void setNativeProvince(String nativeProvince) {
        this.nativeProvince = nativeProvince;
    }

    @Basic
    @Column(name = "native_district")
    public String getNativeDistrict() {
        return nativeDistrict;
    }

    public void setNativeDistrict(String nativeDistrict) {
        this.nativeDistrict = nativeDistrict;
    }

    @Basic
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "edu_exp")
    public String getEduExp() {
        return eduExp;
    }

    public void setEduExp(String eduExp) {
        this.eduExp = eduExp;
    }

    @Basic
    @Column(name = "work_exp")
    public String getWorkExp() {
        return workExp;
    }

    public void setWorkExp(String workExp) {
        this.workExp = workExp;
    }

    @Basic
    @Column(name = "institution_name")
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Basic
    @Column(name = "institution_id")
    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }


    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "achievement")
    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    @Basic
    @Column(name = "investor_intro")
    public String getInvestorIntro() {
        return investorIntro;
    }

    public void setInvestorIntro(String investorIntro) {
        this.investorIntro = investorIntro;
    }

    @Basic
    @Column(name = "web_portrait")
    public String getWebPortrait() {
        return webPortrait;
    }

    public void setWebPortrait(String webPortrait) {
        this.webPortrait = webPortrait;
    }

    @Basic
    @Column(name = "mobile_portrait")
    public String getMobilePortrait() {
        return mobilePortrait;
    }

    public void setMobilePortrait(String mobilePortrait) {
        this.mobilePortrait = mobilePortrait;
    }

    @Basic
    @Column(name = "investor_photo")
    public String getInvestorPhoto() {
        return investorPhoto;
    }

    public void setInvestorPhoto(String investorPhoto) {
        this.investorPhoto = investorPhoto;
    }

    @Column(name = "first_fields")
    public String getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(String firstFields) {
        this.firstFields = firstFields;
    }

    @Basic
    @Column(name = "create_time", insertable = true, updatable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }


    @Basic
    @Column(name = "update_time", insertable = true, updatable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "level_type")
    public Byte getLevelType() {
        return levelType;
    }

    public void setLevelType(Byte levelType) {
        this.levelType = levelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvestorInfoEntity)) return false;

        InvestorInfoEntity that = (InvestorInfoEntity) o;

        return getInvestorId().equals(that.getInvestorId());

    }

    @Override
    public int hashCode() {
        return getInvestorId().hashCode();
    }
}
