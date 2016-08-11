package com.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wd.service.QuestionService;

/**
 * QuestionController
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@RequestMapping("/ web/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
}
