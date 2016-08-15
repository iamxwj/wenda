package com.wd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wd.service.RewardInfoService;

/**
 * QuestionController
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@RequestMapping("/ web/question")
public class RewardInfoController {
	@Autowired
	private RewardInfoService rewardInfoService;
	
	/**      
	 * 方法描述：分页查询所有悬赏
	 * 备注：
	 */
//	@RequestMapping("/findPageReward")
//	@ResponseBody
//	public Message findPageReward(int page, int pagesize){
//		Message message = new Message();
//		message.setCount("查询失败！");
//		message.setResult(false);
//		message.setCore(null);
//		Page<RewardInfo> followAdvice = adviceService.findAll(page, pagesize);
//		if(followAdvice!=null){
////			Date date = followAdvice.getContent().get(0).getCreateDate();
//			message.setCount("查询成功！");
//			message.setResult(true);
//			message.setCore(followAdvice);
//		}
//		return message;
//	}
}
