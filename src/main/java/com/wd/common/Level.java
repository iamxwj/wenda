/*
 * @(#)Level.java, 2015/12/10.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.wd.common;

/**
 * Level
 *
 * @author chenbin
 * @date 2015/12/10
 */
public enum Level {
    ZBU((byte)1, "正部级"), FBU((byte)2, "副部级"), ZTING((byte)3, "正厅级"),
    FTING((byte)4, "副厅级"), ZCHU((byte)5, "正处级"), FCHU((byte)6, "副处级"),
    ZKE((byte)7, "正科级");

    private byte id;
    private String name;

    private Level(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte getId() {
        return id;
    }
}
