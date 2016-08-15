/*
 * @(#)InstitutionListItem.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

import java.io.Serializable;
import java.util.List;

/**
 * InstitutionListItem
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class InstitutionListItem implements Serializable {
    private Long id;
    private String name;
    private String members; // 机构成员
    private int level;
    private String intro;
    private String province;
    private String logoUrl;

    private long fansNumber;
    private int talkNumber;
    private int investNumber;
    private int successIndicator;
    private int activeIndicator;
    private int brandIndicator;

    private List<InstitutionCase> caseList;
    private List<String> investFieldList;
    private List<String> investPhaseList;

    public InstitutionListItem(Long id, String name, List<String> investPhaseList, String members, int level,
                               String intro, long fansNumber, int talkNumber, int investNumber,
                               int successIndicator, int activeIndicator, int brandIndicator, List<String> investFieldList,
                               String logoUrl, List<InstitutionCase> caseList, String province) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.level = level;
        this.intro = intro;
        this.logoUrl = logoUrl;
        this.province = province;

        this.fansNumber = fansNumber;
        this.talkNumber = talkNumber;
        this.investNumber = investNumber;
        this.successIndicator = successIndicator;
        this.activeIndicator = activeIndicator;
        this.brandIndicator = brandIndicator;

        this.caseList = caseList;
        this.investFieldList = investFieldList;
        this.investPhaseList = investPhaseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public long getFansNumber() {
        return fansNumber;
    }

    public void setFansNumber(long fansNumber) {
        this.fansNumber = fansNumber;
    }

    public int getTalkNumber() {
        return talkNumber;
    }

    public void setTalkNumber(int talkNumber) {
        this.talkNumber = talkNumber;
    }

    public int getInvestNumber() {
        return investNumber;
    }

    public void setInvestNumber(int investNumber) {
        this.investNumber = investNumber;
    }

    public int getSuccessIndicator() {
        return successIndicator;
    }

    public void setSuccessIndicator(int successIndicator) {
        this.successIndicator = successIndicator;
    }

    public int getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(int activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public int getBrandIndicator() {
        return brandIndicator;
    }

    public void setBrandIndicator(int brandIndicator) {
        this.brandIndicator = brandIndicator;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public List<InstitutionCase> getCaseList() {
        return caseList;
    }

    public void setCaseList(List<InstitutionCase> caseList) {
        this.caseList = caseList;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<String> getInvestFieldList() {
        return investFieldList;
    }

    public void setInvestFieldList(List<String> investFieldList) {
        this.investFieldList = investFieldList;
    }

    public List<String> getInvestPhaseList() {
        return investPhaseList;
    }

    public void setInvestPhaseList(List<String> investPhaseList) {
        this.investPhaseList = investPhaseList;
    }

    @Override
    public String toString() {
        return "InstitutionListItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members='" + members + '\'' +
                ", level=" + level +
                ", intro='" + intro + '\'' +
                ", fansNumber=" + fansNumber +
                ", talkNumber=" + talkNumber +
                ", investNumber=" + investNumber +
                ", successIndicator=" + successIndicator +
                ", activeIndicator=" + activeIndicator +
                ", brandIndicator=" + brandIndicator +
                ", province='" + province + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", caseList=" + caseList +
                '}';
    }
}
