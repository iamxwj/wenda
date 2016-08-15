/*
 * @(#)InvestorIntro.java, 2016/1/26.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.investor;

/**
 * InvestorIntro
 *
 * @author chenbin
 * @date 2016/1/26
 */
public class InvestorIntro {
    private long investorId;
    private String investorIntro;//简介
    private String achievement; // 成就
    private String eduExp; //教育经历
    private String workExp; //工作经历

    public long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorIntro() {
        return investorIntro;
    }

    public void setInvestorIntro(String investorIntro) {
        this.investorIntro = investorIntro;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
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

    @Override
    public String toString() {
        return "InvestorIntro{" +
                "investorId=" + investorId +
                ", investorIntro='" + investorIntro + '\'' +
                ", achievement='" + achievement + '\'' +
                ", eduExp='" + eduExp + '\'' +
                ", workExp='" + workExp + '\'' +
                '}';
    }
}
