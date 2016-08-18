package com.wd.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wd.dao.QuestionDao;
import com.wd.dao.UserListenDao;
import com.wd.data.ResponseData;
import com.wd.domain.Question;
import com.wd.domain.UserListenEntity;
import com.wd.service.MyselfService;

/**
 * MyselfServiceImpl
 * 
 * @author xwj
 * @version 创建时间：2016年8月18日
*/
@Service
public class MyselfServiceImpl implements MyselfService {
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private UserListenDao userListenDao;
	/**
	 * 显示我自身的悬赏提问
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyQuestion(Long requestorId,int page,int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Page<Question> myQuestionPage = questionDao.findByRequestorIdAndResponseLevelNotNull(requestorId, new PageRequest(page-1, pageSize));
		if(myQuestionPage!=null){
			responseData = new ResponseData(true, "获取成功", myQuestionPage);
		}
		return responseData;
	}
	
	//用于显示我的所有定向提问分页
	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyDirectionalQuestion(Long requestorId, int page, int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Page<Question> myDirectionalPage = questionDao.findByRequestorIdAndResponseLevelIsNull(requestorId, new PageRequest(page, pageSize));
		if(myDirectionalPage!=null){
			responseData = new ResponseData(true, "获取成功", myDirectionalPage);
		}
		return responseData;
	}
	/**
	 * 用于收听投资人
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseData saveUserListenInvestor(long userId, long investorId) {
		UserListenEntity userListen= userListenDao.findByUserIdAndInvestorId(userId,investorId);
		System.out.println(userListen);
		if(userListen!=null){
			return new ResponseData(false, "已收听，请勿重复收听", null);
		}else{
			userListen = new UserListenEntity();
			userListen.setUserId(userId);
			userListen.setInvestorId(investorId);
			userListen = userListenDao.save(userListen);
			return new ResponseData(true, "收听成功", userListen);
		}
	}
	
	/**
	 * 用于收听机构
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public ResponseData saveUserListenInstitution(long userId, long institutionId) {
		UserListenEntity userListen = userListenDao.findByUserIdAndInstitutionId(userId,institutionId);
		if(userListen!=null){
			return new ResponseData(false, "已收听，请勿重复收听", null);
		}else{
			userListen = new UserListenEntity();
			userListen.setUserId(userId);
			userListen.setInstitutionId(institutionId);
			userListen = userListenDao.save(userListen);
			return new ResponseData(true, "收听成功", userListen);
		}
	}
	/**
	 * 用于保存收听的问题
	 */
	@Override
	public ResponseData saveUserListenQuestion(long userId, long questionId){
		UserListenEntity userListen = userListenDao.findByUserIdAndQuestionId(userId,questionId);
		if(userListen!=null){
			return new ResponseData(false, "您已经收听过该问题", userListen);
		}else{
			userListen = new UserListenEntity();
			userListen.setUserId(userId);
			userListen.setQuestionId(questionId);
			userListen = userListenDao.save(userListen);
			return new ResponseData(true, "收听成功", userListen);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyListenByQueryType(Byte queryType,long userId,int page,int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		if(queryType==(byte)1){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndQuestionIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				responseData = new ResponseData(true, "成功获取", userListenList);
				/*List<UserListenEntity> content = userListenList.getContent();
				if(content!=null && content.size()!=0){
					for (UserListenEntity userListenEntity : content) {
						Long questionId = userListenEntity.getQuestionId();
						Question findOne = questionDao.findOne(questionId);
					}
				}*/
			}
		}
		if(queryType==(byte)2){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndInvestorIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				responseData = new ResponseData(true, "成功获取", userListenList);
			}
		}
		if(queryType==(byte)3){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndInstitutionIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				responseData = new ResponseData(true, "成功获取", userListenList);
			}
		}
		return responseData;
	}

}
