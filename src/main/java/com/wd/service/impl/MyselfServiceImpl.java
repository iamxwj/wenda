package com.wd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wd.dao.InstitutionInfoDao;
import com.wd.dao.InvestorInfoDao;
import com.wd.dao.QuestionDao;
import com.wd.dao.UserListenDao;
import com.wd.data.ResponseData;
import com.wd.domain.InstitutionInfoEntity;
import com.wd.domain.InvestorInfoEntity;
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
	
	@Autowired
	private InvestorInfoDao investorInfoDao;
	
	@Autowired
	private InstitutionInfoDao institutionInfoDao;
	/**
	 * 显示我自身的悬赏提问
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyQuestion(Long requestorId,int page,int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Page<Question> myQuestionPage = questionDao.findByRequestorIdAndResponseLevelNotNull(requestorId, new PageRequest(page, pageSize));
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
	/**
	 * 根据queryType 来查询我收听的 以及相关信息，
	 * queryType 可以为1,2,3
	 * 1代表查询收听问题
	 * 2代表查询收听任务
	 * 3代表查询收听机构
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyListenByQueryType(Byte queryType,long userId,int page,int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Map<String,Object> map = new HashMap<>();
		List list = new ArrayList<>();
		if(queryType==(byte)1){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndQuestionIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				List<UserListenEntity> content = userListenList.getContent();
				if(content!=null && content.size()!=0){
					for (UserListenEntity userListenEntity : content) {
						Long questionId = userListenEntity.getQuestionId();
						Question question = questionDao.findOne(questionId);
						list.add(question);
					}
				}
				map.put("userListenList", userListenList);
				map.put("list", list);
				responseData = new ResponseData(true, "成功获取", map);
			}
		}
		if(queryType==(byte)2){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndInvestorIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				List<UserListenEntity> content = userListenList.getContent();
				if(content!=null && content.size()!=0){
					for (UserListenEntity userListenEntity : content) {
						Long investorId = userListenEntity.getInvestorId();
						InvestorInfoEntity investor = investorInfoDao.findOne(investorId);
						list.add(investor);
					}
				}
				map.put("userListenList", userListenList);
				map.put("list", list);
				responseData = new ResponseData(true, "成功获取", map);
			}
		}
		if(queryType==(byte)3){
			Page<UserListenEntity> userListenList = userListenDao.findByUserIdAndInstitutionIdNotNull(userId,new PageRequest(page, pageSize));
			if(userListenList!=null){
				List<UserListenEntity> content = userListenList.getContent();
				if(content!=null && content.size()!=0){
					for (UserListenEntity userListenEntity : content) {
						Long institutionId = userListenEntity.getInstitutionId();
						InstitutionInfoEntity institution = institutionInfoDao.findOne(institutionId);
						list.add(institution);
					}
				}
				map.put("userListenList", userListenList);
				map.put("list", list);
				responseData = new ResponseData(true, "成功获取", map);
			}
		}
		return responseData;
	}
	/**
	 * 通过查询条件 查询我答 分为悬赏问题和定向问题 1为悬赏 2为定向
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getMyAnswerList(long responseId, Byte queryType, int page, int pageSize) {
		ResponseData responseData = new ResponseData(false,"获取失败", null);
		if(queryType==(byte)1){
			Page<Question> answerList= questionDao.findByResponseIdAndResponseLevelNotNull(responseId,new PageRequest(page, pageSize));
			if(answerList!=null){
				responseData = new ResponseData(true,"成功获取", answerList);
				return responseData;
			}
		}
		if(queryType==(byte)2){
			Page<Question> answerList= questionDao.findByResponseIdAndResponseLevelIsNull(responseId,new PageRequest(page, pageSize));
			if(answerList!=null){
				responseData = new ResponseData(true, "成功获取", answerList);
				return responseData;
						
			}
		}
		return responseData;
	}

}
