/*
 * @(#)InvestorDao.java, 2015/11/13.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import com.wd.domain.InvestorInfoEntity;
import com.wd.domain.Question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * InvestorInfoDao
 *
 * @author chenbin
 * @date 2015/11/13
 */
public interface InvestorInfoDao extends JpaSpecificationExecutor<InvestorInfoEntity>,
        JpaRepository<InvestorInfoEntity, Long> {

    /**
     * 通过用户ID获取投资人信息
     * @param userId
     * @return
     */
    @Query("select investor from InvestorInfoEntity investor where investor.userInfoEntity.userId = ?1")
    InvestorInfoEntity findByUserId(long userId);

    /**
     * 通过投资人ID获取投资人信息
     * @param investorId
     * @return
     */
    InvestorInfoEntity findByInvestorId(long investorId);


    List<InvestorInfoEntity> findByFirstFieldsLike(String firstFields);


    List<InvestorInfoEntity> findByInvestorNameLike(String investorName);


    Page<InvestorInfoEntity> findByLevelTypeAndFirstFieldsLike(Byte position, String firstField, Pageable pageRequest);
    
    
    
    public Page<InvestorInfoEntity> findByLevelType(Byte levelType, Pageable pageable);
    
    @Query("select investor from InvestorInfoEntity investor order by listened desc")
    public Page<InvestorInfoEntity> findByHot(Pageable pageable);
}
