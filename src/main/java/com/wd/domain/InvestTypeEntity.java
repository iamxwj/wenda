/*
 * @(#)InvestTypeEntity.java, 2016/1/7.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;

/**
 * InvestTypeEntity
 *
 * @author chenbin
 * @date 2016/1/7
 */
@Entity
@Table(name = "invest_type", schema = "", catalog = "djt")
public class InvestTypeEntity {
    private Byte investTypeId;
    private String typeName;

    @Id
    @Column(name = "invest_type_id")
    public Byte getInvestTypeId() {
        return investTypeId;
    }

    public void setInvestTypeId(Byte investTypeId) {
        this.investTypeId = investTypeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestTypeEntity that = (InvestTypeEntity) o;

        if (investTypeId != null ? !investTypeId.equals(that.investTypeId) : that.investTypeId != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = investTypeId != null ? investTypeId.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
