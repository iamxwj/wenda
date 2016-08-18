//package com.wd.service.impl;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.wd.dao.QuestionDao;
//import com.wd.dao.RewardInfoDao;
//import com.wd.data.ResponseData;
//import com.wd.domain.Question;
//import com.wd.service.RewardInfoService;
//
///**
// * RewardInfoServiceImpl
// * 
// * @author xwj
// * @version 创建时间：2016年8月16日
//*/
//@Service
//public class RewardInfoServiceImpl implements RewardInfoService {
//	private Logger logger = Logger.getLogger(RewardInfoServiceImpl.class);
//	@Autowired
//	private RewardInfoDao rewardInfoDao;
//	
//	@Override
//	@Transactional
//	public ResponseData rewardQuestion(Question question) {
//		ResponseData responseData = new ResponseData(false, "发布悬赏失败", null);
//		if(question==null){
//			String msg="question="+question;
//			logger.error(msg);
//			return new ResponseData(false, msg, null);
//		}
//		Long requestorId = question.getRequestorId();
//		if(requestorId==null){
//			return responseData;
//		}
//		String requestorName = question.getRequestorName();
//		if(requestorName==null){
//			return responseData;
//		}
//		String requestorImg = question.getRequestorImg();
//		if(requestorImg==null){
//			return responseData;
//		}
//		String requestorInstitution = question.getRequestorInstitution();
//		if(requestorInstitution==null){
//			return responseData;
//		}
//		String requestorPost = question.getRequestorPost();
//		if(requestorPost==null){
//			return responseData;
//		}
//		Byte responseLevel = question.getResponseLevel();
//		if(responseLevel==null){
//			return responseData;
//		}
//		try {
//			question = rewardInfoDao.save(question);
//		} catch (Exception e) {
//			return responseData;
//		}
//		responseData = new ResponseData(true, "发布悬赏成功", question);
//		return responseData;
//	}
//}
