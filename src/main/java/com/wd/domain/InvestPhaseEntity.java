/*
 * @(#)InvestPhaseEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;

/**
 * InvestPhaseEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "invest_phase", schema = "", catalog = "djt")
public class InvestPhaseEntity {
    private Byte phaseId;
    private String phaseName;

    @Id
    @Column(name = "phase_id")
    public Byte getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Byte phaseId) {
        this.phaseId = phaseId;
    }

    @Basic
    @Column(name = "phase_name")
    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestPhaseEntity that = (InvestPhaseEntity) o;

        if (phaseId != null ? !phaseId.equals(that.phaseId) : that.phaseId != null) return false;
        if (phaseName != null ? !phaseName.equals(that.phaseName) : that.phaseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = phaseId != null ? phaseId.hashCode() : 0;
        result = 31 * result + (phaseName != null ? phaseName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvestPhaseEntity{" +
                "phaseId=" + phaseId +
                ", phaseName='" + phaseName + '\'' +
                '}';
    }
}
