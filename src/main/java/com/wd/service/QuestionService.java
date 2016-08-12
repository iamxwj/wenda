package com.wd.service;

/**
 * QuestionService
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
public interface QuestionService {
	public String getQuestionPage(Byte questionType,int page,int size);
	public String searchQuestionPage(String content,int page,int size);
}
