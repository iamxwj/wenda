package com.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.data.ResponseData;
import com.wd.domain.QuestionEntity;
import com.wd.service.QuestionService;

/**
 * QuestionController
 * 
 * @author xwj
 * @version 创建时间：2016年8月12日
*/
@Controller
@RequestMapping("/ web/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	//用于获取好问分页
	@RequestMapping("/get/{questionType}/{page}/{size}")
	@ResponseBody
	public ResponseData getQuestionPage(@RequestParam(value="questionType",required=false) Byte questionType,
			@RequestParam(value="page",required=false) Integer page,@RequestParam("size") int size
			){
		if(page==null||page<=0){
			page=1;
		}
		ResponseData responseData = questionService.getQuestionPage(questionType,page,size);
		return responseData;
	}
	
	//用于搜索好问分页
	@RequestMapping("/get/{content}/{page}/{size}")
	@ResponseBody
	public ResponseData searchQuestionPage(@RequestParam(value="content",required=false) String content,
			@RequestParam(value="page",required=false) Integer page,@RequestParam("size") int size
			){
		if(page==null||page<=0){
			page=1;
		}
		ResponseData responseData=null;
		if(content==null||content==""){
			responseData = questionService.getQuestionPage(null, page, size);
		}else{
			responseData = questionService.searchQuestionPage(content,page,size);
		}
		
		return responseData;
	}
}
