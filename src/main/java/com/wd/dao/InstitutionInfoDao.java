/*
 * @(#)InstitutionDao.java, 2015/11/12.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import com.wd.domain.InstitutionInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * InstitutionInfoDao
 *
 * @author chenbin
 * @date 2015/11/12
 */
public interface InstitutionInfoDao extends
        PagingAndSortingRepository<InstitutionInfoEntity, Long> {

    /**
     * 通过用户ID获取机构详情
     * @param userId
     * @return
     */
    @Query("from InstitutionInfoEntity i where i.userInfoEntity.userId = :userId")
    InstitutionInfoEntity findByUserId(@Param("userId") Long userId);

    /**
     * 通过机构ID获取机构详情
     * @param institutionId
     * @return
     */
    @Query("from InstitutionInfoEntity i where i.institutionId = :id")
    InstitutionInfoEntity findByInstitutionId(@Param("id") Long institutionId);

    List<InstitutionInfoEntity> findByInstitutionNameLike(String nameLike);

//    List<InstitutionInfoEntity> findByInvestType(String investType);
//    @Query("from InstitutionInfoEntity i where i.investType =?1 and i.investPhase like ?2")
//    List<InstitutionInfoEntity> findByInvestTypeAndInvestPhaseLike(String investType, String investPhase);

//    List<InstitutionInfoEntity> findByTagLike(String tag);
//    @Query("select i from InstitutionInfoEntity i where i.firstFields like :firstField ")
    Page<InstitutionInfoEntity> findByFirstFieldsLike(@Param("firstField") String firstField, Pageable pageable);
}
