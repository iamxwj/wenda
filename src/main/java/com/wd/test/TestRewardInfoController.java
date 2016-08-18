//package com.wd.test;
//
//import java.util.Date;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.wd.controller.RewardInfoController;
//import com.wd.data.ResponseData;
//import com.wd.domain.Question;
//
///**
// * TestRewardInfoController
// * 
// * @author xwj
// * @version 创建时间：2016年8月16日
//*/
//public class TestRewardInfoController {
//	ApplicationContext ioc=null;
//	RewardInfoController rio = null;
//	{
//		ioc = new ClassPathXmlApplicationContext("spring-context.xml","spring-mvc.xml");
//		rio = ioc.getBean(RewardInfoController.class);
//	}
//	@Test
//	public void test01(){
//		Question ques = new Question();
//		ques.setRequestorName("li5");
//		ques.setResponseDate(new Date());
//		//System.out.println(ques);
//		ResponseData rewardQuestion = rio.rewardQuestion(ques);
//		System.out.println(rewardQuestion);
//	}
//}
