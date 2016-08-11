package com.wd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.wd.dao.QuestionDao;
import com.wd.domain.QuestionEntity;
import com.wd.service.QuestionService;

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

	@Override
	public Page<QuestionEntity> getQuestionPage() {
		
		return questionDao.findAll(new PageRequest(1, 10));
	}
}
