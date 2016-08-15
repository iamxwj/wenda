/*
 * @(#)InstitutionBasicInfoForm.java, 2015/11/28.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

import com.wd.data.ValidResult;

import java.util.List;

/**
 * InstitutionBasicInfo
 *
 * @author chenbin
 * @date 2015/11/28
 */
public class InstitutionBasicInfo {
    private Long institutionId;
    private String institutionName;//机构简称
    private String fundYear; //成立时间
    private Double fundNumber;// 资金数量
    private String fundUnit; //资金单位
    private String staffSize; //员工规模

    private String status; //地位
    private String business; // 业务

    private List<String> firstFields; //所属行业

    private String province; // 总部省
    private String city; // 总部城市
    private String address;// 总部地址

    private String achievement; // 成就
    private String intro; // 机构简介
    private String webLogo; // web 图片
    private String mobileLogo; // mobile 图片

    public ValidResult validateAllFields() {
        if(institutionName == null || institutionName.length() == 0)
            return new ValidResult(false, "institutionName == "+institutionName);
        if(fundNumber == 0)
            return new ValidResult(false, "fundNumber == " + fundNumber);
        if(fundUnit == null || fundUnit.length() == 0)
            return new ValidResult(false, "fundUnit == " + fundUnit);
        if(staffSize == null || staffSize.length() == 0 || staffSize.equalsIgnoreCase("0"))
            return new ValidResult(false, "staffSize == " + staffSize);
        if(province == null || province.length() == 0)
            return new ValidResult(false, "province == " + province);
        if(city == null || city.length() == 0)
            return new ValidResult(false, "city == " + city);
        if(address == null || address.length() == 0)
            return new ValidResult(false, "address == " + address);
//        if(locateProvinces == null || locateProvinces.size() == 0)
//            return new ValidResult(false, "locateProvinces == " + locateProvinces);
//        if(achievement == null || achievement.length() == 0)
//            return new ValidResult(false, "achievement == " + achievement);
        if(intro == null || intro.length() == 0)
            return new ValidResult(false, "intro == " + intro);
//        if(webLogo == null || webLogo.length() == 0)
//            return new ValidResult(false, "webLogo == " + webLogo);
//        if(mobileLogo == null || mobileLogo.length() == 0)
//            return new ValidResult(false, "mobileLogo == " + mobileLogo);
        return new ValidResult(true, "all fields valid");
    }

    @Override
    public String toString() {
        return "InstitutionBasicInfo{" +
                "institutionId=" + institutionId +
                ", institutionName='" + institutionName + '\'' +
                ", fundYear='" + fundYear + '\'' +
                ", fundNumber=" + fundNumber +
                ", fundUnit='" + fundUnit + '\'' +
                ", staffSize='" + staffSize + '\'' +
                ", status='" + status + '\'' +
                ", business='" + business + '\'' +
                ", firstFields=" + firstFields +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", achievement='" + achievement + '\'' +
                ", intro='" + intro + '\'' +
                ", webLogo='" + webLogo + '\'' +
                ", mobileLogo='" + mobileLogo + '\'' +
                '}';
    }

    public String getFundYear() {
        return fundYear;
    }

    public void setFundYear(String fundYear) {
        this.fundYear = fundYear;
    }

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


    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

}
