package com.wd.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wd.domain.Question;


/**   
*    
* 项目名称：wenda   
* 类名称：QuestionDao   
* 创建人：张华   
* 创建时间：2016年8月17日 上午11:31:48      
* @version    
*    
*/
public interface QuestionDao extends PagingAndSortingRepository<Question, Long> {
	/**      
	* 方法描述：根据问题类型分页查询问题信息
	* 备注：
	*/
	public Page<Question> findByQuestionType(String questionType, Pageable pageRequest);
	
	/**      
	* 方法描述：根据问题ID获得问题
	* 备注：
	*/
	public Question findByQuestionId(Long questionId);
	
}
