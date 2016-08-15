/*
 * @(#)CityEntity.java, 2016/1/31.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;

/**
 * CityEntity
 *
 * @author chenbin
 * @date 2016/1/31
 */
@Entity
@Table(name = "city", catalog = "djt")
public class CityEntity {
    private Integer cityId;
    private String cityName;
    private ProvinceEntity provinceEntity;

    @Id
    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @ManyToOne
    @JoinColumn(name = "province_id")
    public ProvinceEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvinceEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }
}
