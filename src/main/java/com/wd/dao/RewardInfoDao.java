/*
 * @(#)InvestorDao.java, 2015/11/13.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wd.domain.RewardInfo;


/**   
*    
* 项目名称：wenda   
* 类名称：RewardInfoDao   
* 创建人：张华   
* 创建时间：2016年8月12日 下午6:38:54      
* @version    
*    
*/
public interface RewardInfoDao extends PagingAndSortingRepository<RewardInfo, Long>{

    /**
     * 通过用户ID获取投资人信息
     * @param userId
     * @return
     */
	
	
}
