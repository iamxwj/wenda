package com.wd.dao;

import com.wd.domain.SmsVerifyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
public interface SmsVerifyDao extends PagingAndSortingRepository<SmsVerifyEntity, Long> {
    List<SmsVerifyEntity> findByPhone(Long phone);
}
