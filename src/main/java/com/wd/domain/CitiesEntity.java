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
@Table(name = "cities", catalog = "djt")
public class CitiesEntity {
    private Integer cityId;
    private String cityName;
    private ProvincesEntity provinceEntity;

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
    public ProvincesEntity getProvinceEntity() {
        return provinceEntity;
    }

    public void setProvinceEntity(ProvincesEntity provinceEntity) {
        this.provinceEntity = provinceEntity;
    }
}
