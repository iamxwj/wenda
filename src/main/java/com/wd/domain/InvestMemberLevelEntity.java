/*
 * @(#)InstitutionMemberLevelEntity.java, 2016/2/25.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.domain;

import javax.persistence.*;

/**
 * InvestMemberLevelEntity
 *
 * @author chenbin
 * @date 2016/2/25
 */
@Entity
@Table(name = "invest_member_level", catalog = "tzdr")
public class InvestMemberLevelEntity {
    private Integer id;
    private String level;
    private String position;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
