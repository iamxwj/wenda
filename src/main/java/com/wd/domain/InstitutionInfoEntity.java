/*
 * @(#)InstitutionInfoEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * InstitutionInfoEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "institution_info", schema = "", catalog = "wd")
public class InstitutionInfoEntity {


    private String fundYear;

    @Column(name = "fund_year")
    public String getFundYear() {
        return fundYear;
    }

    public void setFundYear(String fundYear) {
        this.fundYear = fundYear;
    }

    private Long institutionId;

    @Id
    @Column(name = "institution_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public InstitutionInfoEntity() {
        institutionName = "未命名";
        institutionLevel = 0;
        fundYear = "未知";
        fundNumber = 0.0;
        fundUnit = "未知";
        staffSize = "未知";
        firstFields = "未知";
        webLogo = "";
        mobileLogo = "http://123.56.184.92:4869/38b5110e7095d0274f8ef511175d090c?p=0";
        province = "未知";
        city = "未知";
        address = "未知";
        achievement = "未知";
        institutionIntro = "未知";
        fundYear = "未知";
    }


    private UserInfoEntity userInfoEntity;

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

    private String institutionName;//机构简称

    @Basic
    @Column(name = "institution_name")
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    private Byte institutionLevel; //等级

    @Basic
    @Column(name = "institution_level")
    public Byte getInstitutionLevel() {
        return institutionLevel;
    }

    public void setInstitutionLevel(Byte institutionLevel) {
        this.institutionLevel = institutionLevel;
    }


    private Double fundNumber; //市值金额

    @Basic
    @Column(name = "fund_number")
    public Double getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(Double fundNumber) {
        this.fundNumber = fundNumber;
    }

    private String fundUnit;//市值单位

    @Basic
    @Column(name = "fund_unit")
    public String getFundUnit() {
        return fundUnit;
    }

    public void setFundUnit(String fundUnit) {
        this.fundUnit = fundUnit;
    }

    private String staffSize;//人员规模

    @Basic
    @Column(name = "staff_size")
    public String getStaffSize() {
        return staffSize;
    }

    public void setStaffSize(String staffSize) {
        this.staffSize = staffSize;
    }

    private String status; //地位
    private String business; //业务

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Column(name = "business")
    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    private String firstFields; //行业

    @Column(name = "first_fields")
    public String getFirstFields() {
        return firstFields;
    }

    public void setFirstFields(String firstFields) {
        this.firstFields = firstFields;
    }


    private String webLogo;
    private String mobileLogo;

    @Column(name = "web_logo")
    public String getWebLogo() {
        return webLogo;
    }

    public void setWebLogo(String webLogo) {
        this.webLogo = webLogo;
    }

    @Column(name = "mobile_logo")
    public String getMobileLogo() {
        return mobileLogo;
    }

    public void setMobileLogo(String mobileLogo) {
        this.mobileLogo = mobileLogo;
    }


    private String province;//总部省份

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    private String city; //总部城市

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    private String address; //总部地址

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private String achievement; //成就与荣誉

    @Column(name = "achievement")
    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    private String institutionIntro; // 机构简介

    @Column(name = "institution_intro")
    public String getInstitutionIntro() {
        return institutionIntro;
    }

    public void setInstitutionIntro(String institutionIntro) {
        this.institutionIntro = institutionIntro;
    }


    // 机构成员列表
    private List<InvestorInfoEntity> memberEntityList;

    /**
     * 单向OneToMany, FetchType.LAZY
     *
     * @return
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "institution_id")
    public List<InvestorInfoEntity> getMemberEntityList() {
        return memberEntityList;
    }

    public void setMemberEntityList(List<InvestorInfoEntity> memberEntityList) {
        this.memberEntityList = memberEntityList;
    }


    private Timestamp createTime;

    @Basic
    @Column(name = "create_time", insertable = false, updatable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    private Timestamp updateTime;

    @Basic
    @Column(name = "update_time", insertable = false, updatable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    private int answerNumber;
    
    private int listened;

    @Column(name = "answer_number")
	public int getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}
	@Column
	public int getListened() {
		return listened;
	}

	public void setListened(int listened) {
		this.listened = listened;
	}
    
    
}
