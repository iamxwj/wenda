/*
 * @(#)InvestFieldEntity.java, 2015/12/2.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;

/**
 * InvestFieldEntity
 *
 * @author chenbin
 * @date 2015/12/2
 */
@Entity
@Table(name = "invest_field", schema = "", catalog = "djt")
public class InvestFieldEntity {
    private Byte fieldId;
    private String fieldName;
    private String fieldType;

    @Id
    @Column(name = "field_id")
    public Byte getFieldId() {
        return fieldId;
    }

    public void setFieldId(Byte fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "field_name")
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Basic
    @Column(name = "field_type")
    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestFieldEntity that = (InvestFieldEntity) o;

        if (fieldId != null ? !fieldId.equals(that.fieldId) : that.fieldId != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (fieldType != null ? !fieldType.equals(that.fieldType) : that.fieldType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fieldId != null ? fieldId.hashCode() : 0;
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InvestFieldEntity{" +
                "fieldId=" + fieldId +
                ", fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                '}';
    }
}
