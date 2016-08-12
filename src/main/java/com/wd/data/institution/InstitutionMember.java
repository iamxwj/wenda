/*
 * @(#)InstitutionMember.java, 2015/11/30.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data.institution;

import com.wd.data.ValidResult;

import java.io.Serializable;

/**
 * InstitutionMember
 *
 * @author chenbin
 * @date 2015/11/30
 */
public class InstitutionMember implements Serializable {
    private Long institutionId;
    private Long memberId;
    private String memberName;
    private byte memberLevel;
    private String memberPosition;
    private String memberPhotoPath;

    public InstitutionMember() {}

    public InstitutionMember(long memberId, String memberName, byte memberLevel, String memberPosition, String memberPhotoPath) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberLevel = memberLevel;
        this.memberPosition = memberPosition;
        this.memberPhotoPath = memberPhotoPath;
    }

    public ValidResult validateAllFields() {
        if(memberName == null || memberName.length() == 0)
            return new ValidResult(false, "memberName == " + memberName);
        if(memberPosition == null || memberPosition.length() == 0)
            return new ValidResult(false, "memberPosition == " + memberPosition);
        if(institutionId == null || institutionId == 0)
            return new ValidResult(false, "institutionId == " + institutionId);

        return new ValidResult(true, toString());
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public byte getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(byte memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemberPosition() {
        return memberPosition;
    }

    public void setMemberPosition(String memberPosition) {
        this.memberPosition = memberPosition;
    }

    public String getMemberPhotoPath() {
        return memberPhotoPath;
    }

    public void setMemberPhotoPath(String memberPhotoPath) {
        this.memberPhotoPath = memberPhotoPath;
    }

    @Override
    public String toString() {
        return "InstitutionMember{" +
                "institutionId=" + institutionId +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberLevel=" + memberLevel +
                ", memberPosition='" + memberPosition + '\'' +
                ", memberPhotoUrl='" + memberPhotoPath + '\'' +
                '}';
    }
}
