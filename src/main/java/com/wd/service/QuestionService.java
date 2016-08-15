package com.wd.service;

import com.wd.data.ResponseData;

/**
 * QuestionService
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
public interface QuestionService {
	/**
	 * 用于获取好问分页
	 * @param questionType
	 * @param page
	 * @param size
	 * @return
	 */
	public ResponseData getQuestionPage(Byte questionType,int page,int size);
	/**
	 * 用于搜索好问分页
	 * @param content
	 * @param page
	 * @param size
	 * @return
	 */
	public ResponseData searchQuestionPage(String content,int page,int size);
}
