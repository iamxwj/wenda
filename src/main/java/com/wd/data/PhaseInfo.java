/*
 * @(#)PhaseInfo.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

import java.io.Serializable;

/**
 * PhaseInfo
 *
 * @author chenbin
 * @date 2015/12/4
 */
public class PhaseInfo implements Serializable {
    private Byte phaseId;
    private String phaseName;

    public PhaseInfo(Byte phaseId, String phaseName) {
        this.phaseId = phaseId;
        this.phaseName = phaseName;
    }

    public Byte getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Byte phaseId) {
        this.phaseId = phaseId;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    @Override
    public String toString() {
        return "PhaseInfo{" +
                "phaseId=" + phaseId +
                ", phaseName='" + phaseName + '\'' +
                '}';
    }
}
