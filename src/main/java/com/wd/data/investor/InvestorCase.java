/*
 * @(#)InvestorCase.java, 2016/1/18.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.investor;

import com.wd.data.ValidResult;

/**
 * InvestorCase
 *
 * @author chenbin
 * @date 2016/1/18
 */
public class InvestorCase {
    private Long id;
    private Long investorId;
    private String name;
    private String investNumber;
    private String caseUrl;
    private String investUnit;

    public InvestorCase(Long id, Long investorId, String name, String investNumber, String caseUrl, String investUnit) {
        this.id = id;
        this.investorId = investorId;
        this.name = name;
        this.investNumber = investNumber;
        this.caseUrl = caseUrl;
        this.investUnit = investUnit;
    }

    public ValidResult validateAllFields() {
        if(investorId == 0)
            return new ValidResult(false, "investorId == " + investorId);
        if(name == null || name.length() == 0)
            return new ValidResult(false, "name == " + name);

        return new ValidResult(true, "investId, name, investNumber valid");
    }



    public String getInvestUnit() {
        return investUnit;
    }

    public void setInvestUnit(String investUnit) {
        this.investUnit = investUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvestNumber() {
        return investNumber;
    }

    public void setInvestNumber(String investNumber) {
        this.investNumber = investNumber;
    }

    public String getCaseUrl() {
        return caseUrl;
    }

    public void setCaseUrl(String caseUrl) {
        this.caseUrl = caseUrl;
    }

    @Override
    public String toString() {
        return "InvestorCase{" +
                "id=" + id +
                ", investorId=" + investorId +
                ", name='" + name + '\'' +
                ", investNumber='" + investNumber + '\'' +
                ", caseUrl='" + caseUrl + '\'' +
                ", investUnit='" + investUnit + '\'' +
                '}';
    }

    public InvestorCase() {

    }
}
