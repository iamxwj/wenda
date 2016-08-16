package com.wd.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wd.controller.QuestionController;
import com.wd.data.ResponseData;

/**
 * TestQuestionController
 * 
 * @author xwj
 * @version 创建时间：2016年8月12日
*/
public class TestQuestionController {
	ApplicationContext ioc = null;
	QuestionController qc = null;
	{
		ioc=new ClassPathXmlApplicationContext("spring-context.xml","spring-mvc.xml");
		qc = ioc.getBean(QuestionController.class);
	}
	@Test
	public void test01(){
		ResponseData responseData= qc.getQuestionPage((byte) 1, 0, 2);
		/*long totalElements = questionPage.getTotalElements();
		int totalPages = questionPage.getTotalPages();
		List<QuestionEntity> content = questionPage.getContent();
		System.out.println(totalElements);
		System.out.println(totalPages);
		for (QuestionEntity questionEntity : content) {
			System.out.println(questionEntity);
		}*/
		System.out.println(responseData);
		//aString searchQuestionPage = qc.searchQuestionPage(null, 0, 2);
		//System.out.println(searchQuestionPage);
	}
}
