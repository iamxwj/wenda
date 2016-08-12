package com.wd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wd.dao.InvestorInfoDao;
import com.wd.dao.QuestionDao;
import com.wd.dao.QuestionListenDao;
import com.wd.domain.InvestorInfoEntity;
import com.wd.domain.QuestionEntity;
import com.wd.service.QuestionService;
import com.wd.utils.JSONUtil;

/**
 * QuestionServiceImpl
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private InvestorInfoDao investorInfoDao;
	@Autowired
	private QuestionListenDao questionListenDao;
	/**
	 * 用于获取好问分页
	 */
	@Override
	@Transactional(readOnly=true)
	public String getQuestionPage(Byte questionType,int page,int size) {
		String objectToJSONString=null;
		if(questionType==null){
			Page<QuestionEntity> questionPage = questionDao.findAll(new PageRequest(page-1, size));
			Map<String,Object> map=null;
			Map<String,Object> map1 = null;
			List list = new ArrayList<>();
			
			if(questionPage!=null){
				List<QuestionEntity> content = questionPage.getContent();
				if(content!=null&&content.size()!=0){
					for (QuestionEntity questionEntity : content) {
						map = new HashMap<>();
						//Long responseId = questionEntity.getResponseId();
						/*if(responseId!=null){
							InvestorInfoEntity findByInvestorId = investorInfoDao.findByInvestorId(responseId);
							String investorName = findByInvestorId.getInvestorName();
							String institutionName = findByInvestorId.getInstitutionName();
							String investorPosition = findByInvestorId.getInvestorPosition();
							map.put("answerInstitution", institutionName);
							map.put("answerPost", investorPosition);
							map.put("answerName", investorName);
						}*/
						Long questionId = questionEntity.getQuestionId();
						if(questionId!=null){
							long numberLister = questionListenDao.getCountByQuestionId(questionId);
							map.put("numberLister", numberLister);
						}
						map.put("questionId", questionEntity.getQuestionId());
						map.put("img", questionEntity.getVoiceUrl());
						list.add(map);
					}
				}
				try {
					map1 = new HashMap<>();
					map1.put("success", true);
					map1.put("message", "获取好问列表");
					map1.put("obj", list);
					objectToJSONString = JSONUtil.ObjectToJSONString(map1);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			return objectToJSONString;
		}else{
			Page<QuestionEntity> findByQuestionType = questionDao.findByQuestionType(questionType, new PageRequest(page-1, size));
			Map<String,Object> map=null;
			Map<String,Object> map1 = null;
			List list = new ArrayList<>();
			
			if(findByQuestionType!=null){
				List<QuestionEntity> content = findByQuestionType.getContent();
				if(content!=null&&content.size()!=0){
					for (QuestionEntity questionEntity : content) {
						map = new HashMap<>();
						Long responseId = questionEntity.getResponseId();
						if(responseId!=null){
							InvestorInfoEntity findByInvestorId = investorInfoDao.findByInvestorId(responseId);
							String investorName = findByInvestorId.getInvestorName();
							String institutionName = findByInvestorId.getInstitutionName();
							String investorPosition = findByInvestorId.getInvestorPosition();
							map.put("answerInstitution", institutionName);
							map.put("answerPost", investorPosition);
							map.put("answerName", investorName);
						}
						Long questionId = questionEntity.getQuestionId();
						if(questionId!=null){
							long numberLister = questionListenDao.getCountByQuestionId(questionId);
							map.put("numberLister", numberLister);
						}
						map.put("questionId", questionEntity.getQuestionId());
						map.put("img", questionEntity.getVoiceUrl());
						list.add(map);
					}
				}
				try {
					map1 = new HashMap<>();
					map1.put("success", true);
					map1.put("message", "获取好问列表");
					map1.put("obj", list);
					objectToJSONString = JSONUtil.ObjectToJSONString(map1);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			return objectToJSONString;
		}
	}
	/**
	 * 用于搜索好问分页
	 * @return
	 */
	public String searchQuestionPage(String content,int page,int size){
		return null;
	}
	
}
