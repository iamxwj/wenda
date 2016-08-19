package com.wd.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wd.domain.UserListenEntity;

/**
 * UserListenDao
 * 
 * @author xwj
 * @version 创建时间：2016年8月18日
*/
public interface UserListenDao extends PagingAndSortingRepository<UserListenEntity, Long> {
	/**
	 * 通过userId和investorId来查询
	 * @param userId
	 * @param investorId
	 * @return
	 */
	UserListenEntity findByUserIdAndInvestorId(long userId, long investorId);
	
	/**
	 * 通过userId和institutionId来查询
	 * @param userId
	 * @param institutionId
	 * @return
	 */
	UserListenEntity findByUserIdAndInstitutionId(long userId, long institutionId);
	/**
	 * 通过userId和questionId来查询
	 * @param userId
	 * @param questionId
	 * @return
	 */
	UserListenEntity findByUserIdAndQuestionId(long userId, long questionId);
	/**
	 * 通过userId以及questionId不是null来查询
	 * @param userId
	 * @return
	 */
	Page<UserListenEntity> findByUserIdAndQuestionIdNotNull(long userId,Pageable pageable);

	Page<UserListenEntity> findByUserIdAndInvestorIdNotNull(long userId,Pageable pageable);

	Page<UserListenEntity> findByUserIdAndInstitutionIdNotNull(long userId,Pageable pageable);

}
