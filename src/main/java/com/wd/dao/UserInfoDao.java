/*
 * @(#)UserInfoDao.java, 2015/10/27.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import com.wd.domain.UserInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * UserInfoDao
 *
 * @author chenbin
 * @date 2015/10/27
 */
public interface UserInfoDao extends CrudRepository<UserInfoEntity, Long> {

    UserInfoEntity findByName(String name);

    UserInfoEntity findByEmail(String email);

    UserInfoEntity findByMobile(String mobile);

    @Query("select case when count(user) > 0 then true else false end from UserInfoEntity user where user.name = ?1")
    boolean existsName(String username);

    @Query("select case when count(user) > 0 then true else false end from UserInfoEntity user where user.email = ?1")
    boolean existsByEmail(String email);

    @Query("select case when count(user) > 0 then true else false end from UserInfoEntity user where user.mobile = ?1")
    boolean existsByMobile(String mobile);
}
