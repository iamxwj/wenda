/*
 * @(#)PhotoInfo.java, 2016/4/8.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

import java.util.List;

/**
 * PhotoInfo
 *
 * @author chenbin
 * @date 2016/4/8
 */
public class PhotoInfo {
    private Long id;
    private List<String> url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
