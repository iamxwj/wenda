//package com.wd.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.wd.data.Message;
//import com.wd.domain.RewardInfo;
//import com.wd.service.RewardInfoService;
//
//
///*  
//*    
//* 项目名称：wenda   
//* 类名称：RewardInfoController   
//* 创建人：张华   
//* 创建时间：2016年8月15日 上午10:50:30      
//* @version    
//*    
//*/
//@Controller
//@RequestMapping("/web/reward")
//public class RewardInfoController {
//	@Autowired
//	private RewardInfoService rewardInfoService;
//	
//	
//	/**      
//	 * 方法描述：发布悬赏
//	 * 备注：
//	 */
//	@RequestMapping("/addReward")
//	@ResponseBody
//	public Message addReward(RewardInfo rewardInfo){
//		Message message = new Message();
//		message.setCount("发布悬赏失败！");
//		message.setResult(false);
//		message.setCore(null);
//		RewardInfo newReward = rewardInfoService.addReward(rewardInfo);
//		if(newReward!=null){
//			message.setCount("发布悬赏成功！");
//			message.setResult(true);
//			message.setCore(newReward);
//		}
//		return message;
//	}
//	/**      
//	 * 方法描述：分页查询所有悬赏
//	 * 备注：
//	 */
////	@RequestMapping("/findPageReward")
////	@ResponseBody
////	public Message findPageReward(int page, int pagesize){
////		Message message = new Message();
////		message.setCount("查询失败！");
////		message.setResult(false);
////		message.setCore(null);
////		Page<RewardInfo> followAdvice = adviceService.findAll(page, pagesize);
////		if(followAdvice!=null){
//////			Date date = followAdvice.getContent().get(0).getCreateDate();
////			message.setCount("查询成功！");
////			message.setResult(true);
////			message.setCore(followAdvice);
////		}
////		return message;
////	}
//}
