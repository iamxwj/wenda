package com.wd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wd.dao.QuestionDao;
import com.wd.data.ResponseData;
import com.wd.domain.Question;
import com.wd.service.MyAnswerService;

/**
 * MyAnswerServiceImpl
 * 
 * @author xwj
 * @version 创建时间：2016年8月19日
*/
@Service
public class MyAnswerServiceImpl implements MyAnswerService {
	@Autowired
	private QuestionDao QuestionDao;
	/**
	 * 用于待抢答分页
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getUnAnswerQuestion(long requestorId,byte questionState,int page,int pageSize) {
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Page<Question> unAnswerQuestionList = QuestionDao.findByRequestorIdNotAndQuestionStateAndResponseLevelNotNull(requestorId,questionState,new PageRequest(page, pageSize));
		if(unAnswerQuestionList!=null){
			responseData = new ResponseData(true, "成功获取", unAnswerQuestionList);
		}
		return responseData;
	}
	/**
	 * 用于已抢答分页
	 */
	@Override
	@Transactional(readOnly=true)
	public ResponseData getAnsweredQuestion(long responseId, int page, int pageSize) {
		Byte questionState = (byte)2;
		ResponseData responseData = new ResponseData(false, "获取失败", null);
		Page<Question> answeredQuestionList = QuestionDao.findByResponseIdAndQuestionStateAndResponseLevelNotNull(responseId,questionState,new PageRequest(page, pageSize));
		if(answeredQuestionList!=null){
			responseData = new ResponseData(true, "成功获取", answeredQuestionList);
		}
		return responseData;
	}
}
