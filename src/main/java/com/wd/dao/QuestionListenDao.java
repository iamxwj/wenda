package com.wd.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wd.domain.QuestionListenEntity;

/**
 * QuestionListerDao
 * 
 * @author xwj
 * @version 创建时间：2016年8月12日
*/
public interface QuestionListenDao extends CrudRepository<QuestionListenEntity, Long>{
	@Query("select count(ql) from QuestionListenEntity ql where ql.questionId=?1")
	long getCountByQuestionId(long questionId);
}
