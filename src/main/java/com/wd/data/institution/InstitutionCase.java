/*
 * @(#)InstitutionCase.java, 2016/1/18.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

import com.wd.data.ValidResult;

/**
 * InstitutionCase
 *
 * @author chenbin
 * @date 2016/1/18
 */
public class InstitutionCase {
    private Long id;
    private Long institutionId;
    private String name;
    private String investNumber;
    private String photoPath;
    private String investUnit;


    public InstitutionCase() {
    }

    public InstitutionCase(long id, long institutionId, String name, String investNumber, String photoPath, String investUnit) {
        this.id = id;
        this.institutionId = institutionId;
        this.name = name;
        this.investNumber = investNumber;
        this.photoPath = photoPath;
        this.investUnit = investUnit;
    }


    public ValidResult validateAllFields() {
        if (institutionId == null || institutionId == 0)
            return new ValidResult(false, "institutionId = " + institutionId);
        if (name == null || name.length() == 0)
            return new ValidResult(false, "name = " + name);
        if (photoPath == null || photoPath.length() == 0)
            return new ValidResult(false, "photoPath = " + photoPath);

        return new ValidResult(true, toString());
    }

    public Long getId() {
        return id;
    }

    public Long getInstitutionId() {
        return institutionId;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "InstitutionCase{" +
                "id=" + id +
                ", institutionId=" + institutionId +
                ", name='" + name + '\'' +
                ", investNumber='" + investNumber + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", investUnit='" + investUnit + '\'' +
                '}';
    }

    public String getInvestUnit() {
        return investUnit;
    }

    public void setInvestUnit(String investUnit) {
        this.investUnit = investUnit;
    }
}
