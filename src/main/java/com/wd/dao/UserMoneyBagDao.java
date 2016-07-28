package com.wd.dao;

import com.wd.domain.UserMoneyBagEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Zhipeng on 2016/5/10.
 */
public interface UserMoneyBagDao extends PagingAndSortingRepository<UserMoneyBagEntity, Long> {
    UserMoneyBagEntity findByUserId(Long userId);
}
