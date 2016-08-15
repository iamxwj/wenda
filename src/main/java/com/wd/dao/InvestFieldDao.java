/*
 * @(#)InvestFieldDao.java, 2015/12/4.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import com.wd.domain.InvestFieldEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * InvestFieldDao
 *
 * @author chenbin
 * @date 2015/12/4
 */
public interface InvestFieldDao extends CrudRepository<InvestFieldEntity, Byte> {

    @Query("select ife.fieldType from InvestFieldEntity ife group by ife.fieldType")
    List<String> findFieldTypeList();

    @Query("from InvestFieldEntity ife where ife.fieldType = ?1")
    List<InvestFieldEntity> findFieldList(String fieldType);
}
