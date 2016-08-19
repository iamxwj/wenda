package com.wd.dao;
import java.util.List;

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
	 * 用于查询我的所有悬赏问题
	 * @param requestorId
	 * @param pageRequest
	 * @return
	 */
	public Page<Question> findByRequestorIdAndResponseLevelIsNull(Long requestorId,Pageable pageRequest);
	
	/**
	 * 用于查询我的所有的定向问题
	 * @param requestorId
	 * @param pageRequest
	 * @return
	 */
	public Page<Question> findByRequestorIdAndResponseLevelNotNull(Long requestorId,Pageable pageRequest);
	
	/**      
	* 方法描述：根据问题ID获得问题
	* 备注：
	*/
	
	public Question findByQuestionId(Long questionId);
	
	/**      
	 * 方法描述：根据回答者ID获得问题
	 * 备注：
	 */
	public Page<Question> findByResponseId(Long responseId, Pageable pageable);
	
}
