package com.wd.service;

import org.springframework.data.domain.Page;
import com.wd.domain.QuestionEntity;

/**
 * QuestionService
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
public interface QuestionService {
	public Page<QuestionEntity> getQuestionPage();
}
