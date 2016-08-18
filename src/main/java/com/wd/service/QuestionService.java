package com.wd.service;

import com.wd.data.ResponseData;
import com.wd.domain.Question;


/**   
*    
* 项目名称：wenda   
* 类名称：QuestionService   
* 创建人：张华   
* 创建时间：2016年8月17日 下午4:59:08      
* @version    
*    
*/
public interface QuestionService {
	/**
	 * 用于获取好问分页
	 * @param questionType
	 * @param page
	 * @param size
	 * @return
	 */
	public ResponseData getQuestionPage(String questionType,int page, int pagesize);
	/**      
	* 方法描述：添加问题/发布悬赏
	* 备注：
	*/
	public ResponseData addQuestion(Question question);
	
	
	
//	/**
//	 * 用于搜索好问分页
//	 * @param content
//	 * @param page
//	 * @param size
//	 * @return
//	 */
//	public ResponseData searchQuestionPage(String content,int page,int size);
}
