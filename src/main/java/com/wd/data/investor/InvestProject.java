/*
 * @(#)InvestProjectDetail.java, 2015/11/17.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.investor;

import java.io.Serializable;

/**
 * InvestProject
 *
 * @author chenbin
 * @date 2015/11/17
 */
public class InvestProject implements Serializable {
    private long investProjectId;
    private String investProjectName;
    private byte investProjectLevel;
    private String investProjectLogoUrl;


    public InvestProject(long investProjectId, String investProjectName,
                         byte investProjectLevel, String investProjectLogoUrl) {
        this.investProjectId = investProjectId;
        this.investProjectName = investProjectName;
        this.investProjectLevel = investProjectLevel;
        this.investProjectLogoUrl = investProjectLogoUrl;
    }


    public long getInvestProjectId() {
        return investProjectId;
    }

    public void setInvestProjectId(long investProjectId) {
        this.investProjectId = investProjectId;
    }

    public String getInvestProjectName() {
        return investProjectName;
    }

    public void setInvestProjectName(String investProjectName) {
        this.investProjectName = investProjectName;
    }

    public byte getInvestProjectLevel() {
        return investProjectLevel;
    }

    public void setInvestProjectLevel(byte investProjectLevel) {
        this.investProjectLevel = investProjectLevel;
    }

    public String getInvestProjectLogoUrl() {
        return investProjectLogoUrl;
    }

    public void setInvestProjectLogoUrl(String investProjectLogoUrl) {
        this.investProjectLogoUrl = investProjectLogoUrl;
    }

    @Override
    public String toString() {
        return "InvestProject{" +
                "investProjectId=" + investProjectId +
                ", investProjectName='" + investProjectName + '\'' +
                ", investProjectLevel=" + investProjectLevel +
                ", investProjectLogoUrl='" + investProjectLogoUrl + '\'' +
                '}';
    }
}
