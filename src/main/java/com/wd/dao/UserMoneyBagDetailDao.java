package com.wd.dao;

import com.wd.domain.UserMoneyBagDetailEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Zhipeng on 2016/5/10.
 */
public interface UserMoneyBagDetailDao extends PagingAndSortingRepository<UserMoneyBagDetailEntity, Long> {
    List<UserMoneyBagDetailEntity> findByUserId(Long userId);
}
