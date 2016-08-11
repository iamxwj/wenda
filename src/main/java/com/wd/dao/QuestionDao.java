package com.wd.dao;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.wd.domain.QuestionEntity;

/**
 * QuestionDao
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
public interface QuestionDao extends PagingAndSortingRepository<QuestionEntity, Long> {
	//查询所有的问题信息
	/*@Query("select count(question) from QuestionEntity question")
	long getTotalElements();
	
	@Query("select question")
	List<QuestionEntity> getQuestionList();
	*/
}
