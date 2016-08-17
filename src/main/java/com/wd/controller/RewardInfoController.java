package com.wd.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.data.ResponseData;
import com.wd.domain.Question;
import com.wd.service.RewardInfoService;

/**
 * RewardInfoController
 * 
 * @author xwj
 * @version 创建时间：2016年8月16日
*/
@Controller
@RequestMapping("/web/question")
public class RewardInfoController {
	@Autowired
	private RewardInfoService RewardInfoService;
	/**
	 * 用于创建悬赏
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/reward",method=RequestMethod.POST)
	@ResponseBody
	public ResponseData rewardQuestion(Question question){
		ResponseData responseData = RewardInfoService.rewardQuestion(question);
		return responseData;
	}
}
