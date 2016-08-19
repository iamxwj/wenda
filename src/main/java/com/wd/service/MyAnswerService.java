package com.wd.service;

import com.wd.data.ResponseData;

/**
 * MyAnswer
 * 
 * @author xwj
 * @version 创建时间：2016年8月19日
*/
public interface MyAnswerService {
	/**
	 * 用于待抢答问题分页
	 * @param requestorId
	 * @param questionState
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ResponseData getUnAnswerQuestion(long requestorId,byte questionState,int page,int pageSize);
	/**
	 * 用于已抢答问题分页
	 * @param responseId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ResponseData getAnsweredQuestion(long responseId, int page, int pageSize);

}
