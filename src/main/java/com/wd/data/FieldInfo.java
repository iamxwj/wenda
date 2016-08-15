/*
 * @(#)FieldInfo.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

import java.io.Serializable;

/**
 * FieldInfo
 *
 * @author chenbin
 * @date 2015/12/4
 */
public class FieldInfo implements Serializable{
    private Byte fieldId;
    private String fieldName;

    public FieldInfo(Byte fieldId, String fieldName) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
    }

    public Byte getFieldId() {
        return fieldId;
    }

    public void setFieldId(Byte fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "fieldId=" + fieldId +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
