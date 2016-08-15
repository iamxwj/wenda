/*
 * @(#)InstitutionIdName.java, 2016/1/25.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

/**
 * InstitutionIdName
 *
 * @author chenbin
 * @date 2016/1/25
 */
public class InstitutionIdName {
    private Long institutionId;
    private String institutionName;

    public InstitutionIdName(long institutionId, String institutionName) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
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

    @Override
    public String toString() {
        return "InstitutionIdName{" +
                "institutionId=" + institutionId +
                ", institutionName='" + institutionName + '\'' +
                '}';
    }
}
