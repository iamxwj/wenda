/*
 * @(#)ProvinceDao.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import com.wd.domain.ProvinceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * ProvinceDao
 *
 * @author chenbin
 * @date 2015/12/4
 */
public interface ProvinceDao extends PagingAndSortingRepository<ProvinceEntity, Integer> {
}
