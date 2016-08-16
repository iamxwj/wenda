//
// /* @(#)CaptchaServiceImpl.java, 2015/11/9.
// *
// * Copyright 2015 Alibaodu, Inc. All rights reserved.
// * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.*/
// 
//
//package com.wd.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.wd.dao.RewardInfoDao;
//import com.wd.domain.RewardInfo;
//import com.wd.service.RewardInfoService;
//
///*
// * CaptchaServiceImpl
// *
// * @author HOU Zhipeng
// * @date 2016/06/12
// */
//@Service
//public class RewardInfoServiceImpl implements RewardInfoService {
//	
//	
//	@Autowired
//    private RewardInfoDao RewardInfodao;
//	
//	/*    
//	 * 方法描述：分页查询所有悬赏信息
//	 * 备注：
//	 */
//	@Override
//	public Page<RewardInfo> findAll(int page, int pagesize) {
//		Pageable pageable = new PageRequest(page, pagesize);
//		Page<RewardInfo> pageReward = RewardInfodao.findAll(pageable);
//		return pageReward;
//	}
//	
//	/*     
//	 * 方法描述：添加悬赏信息
//	 * 备注：
//	 */
//	@Override
//	public RewardInfo addReward(RewardInfo rewardInfo) {
//		RewardInfo newRewardInfo = RewardInfodao.save(rewardInfo);
//		return newRewardInfo;
//	}
//
////	@Override
////	public Page<RewardInfo> findAllByType(int page, int pagesize, Byte type) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}