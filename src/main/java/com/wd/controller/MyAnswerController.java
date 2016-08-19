package com.wd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.data.ResponseData;
import com.wd.service.MyAnswerService;
import com.wd.service.QuestionService;

/**
 * MyAnswerController
 * 
 * @author xwj
 * @version 创建时间：2016年8月19日
*/
@Controller
@RequestMapping("/web/answer")
public class MyAnswerController {
	@Autowired
	private MyAnswerService myAnswerService;
	
	@Autowired
	private QuestionService questionService;
	/**
	 * 用于获取待抢答问题的分页
	 * @param map
	 * @return
	 */
	@RequestMapping("/un_answer")
	@ResponseBody
	public ResponseData getUnAnswerQuestion(@RequestBody Map map){
		int userId1 = (int)map.get("userId");
		long userId = (long)userId1;
		byte questionState=(byte)1;
		int page = (int) map.get("page");
		int pageSize = (int)map.get("pageSize");
		ResponseData responseData = myAnswerService.getUnAnswerQuestion(userId,questionState,page,pageSize);
		return responseData;
	}
	/**
	 * 用于获取已抢答问题分页
	 * @param map
	 * @return
	 */
	@RequestMapping("/answered")
	@ResponseBody
	public ResponseData getAnsweredQuestion(@RequestBody Map map){
		int userId1= (int)map.get("userId");
		long responseId= (long)userId1;
		int page = (int)map.get("page");
		int pageSize = (int)map.get("pageSize");
		ResponseData responseData = myAnswerService.getAnsweredQuestion(responseId,page,pageSize);
		return responseData;
	}
	/**
	 * 去抢答-显示问题详细信息
	 * @param map
	 * @return
	 */
	@RequestMapping("/for_answer")
	@ResponseBody
	public ResponseData toAnswer(@RequestBody Map map){
		int questionId1 = (int)map.get("questionId");
		long questionId = (long)questionId1;
		return questionService.findByQuestionId(questionId);
	}
}
