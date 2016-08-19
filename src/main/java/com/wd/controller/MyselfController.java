package com.wd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.data.ResponseData;
import com.wd.domain.UserListenEntity;
import com.wd.service.MyselfService;

/**
 * MyselfController
 * 
 * @author xwj
 * @version 创建时间：2016年8月18日
*/
@Controller
@RequestMapping("/web/my")
public class MyselfController {
	@Autowired
	private MyselfService myselfService;
	/**
	 * 获取我自身的悬赏提问
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/question_list")
	@ResponseBody
	public ResponseData getMyQuestionPage(@RequestBody Map map){
		Byte queryType = null;
		Object queryType1 = map.get("queryType");
		ResponseData responseData = null;
		if(queryType1==null){
			queryType=(byte)1;
		}else{
			int queryType2=(int)queryType1;
			queryType=(byte)queryType2;
		}
		int requestorId1 = (int)map.get("userId");
		long requestorId = (long)requestorId1;
		int page=(int)map.get("page");
		int pageSize= (int)map.get("pageSize");
		if(queryType==(byte)1){
			responseData = myselfService.getMyQuestion(requestorId, page, pageSize);
		}
		if(queryType==(byte)2){
			responseData = myselfService.getMyDirectionalQuestion(requestorId, page, pageSize);
		}
		return responseData;
	}
	
	/**
	 * 获取自身定向提问
	 * @param map
	 * @return
	 */
	/*@RequestMapping("/directional_question")
	@ResponseBody
	public ResponseData getMyDirectionalQuestionPage(@RequestBody Map map){
		int requestorId1 = (int)map.get("requestorId");
		long requestorId = (long)requestorId1;
		int page=(int)map.get("page");
		int pageSize= (int)map.get("pageSize");
		ResponseData responseData = myselfService.getMyDirectionalQuestion(requestorId, page, pageSize);
		return responseData;
	}
	*/
	/**
	 * 用于收听投资人或者机构以及问题收听
	 * @param map
	 * @return
	 */
	@RequestMapping("/listen_add")
	@ResponseBody
	public ResponseData saveUserListen(@RequestBody Map map){
		ResponseData responseData = new ResponseData(false, "收听失败", null);
		int userId1 = (int)map.get("userId");
		long userId = (long)userId1;
		Object investorId1 = map.get("investorId");
		Object institutionId1 = map.get("institutionId");
		Object questionId1 = map.get("questionId");
		if(investorId1!=null || institutionId1!=null || questionId1!=null){
			if(investorId1!=null){
				int investorId2 = (int)investorId1;
				long investorId = (long)investorId2;
				responseData=myselfService.saveUserListenInvestor(userId,investorId);
			}
			if(institutionId1!=null){
				int institutionId2 = (int)institutionId1;
				long institutionId = (long)institutionId2;
				responseData = myselfService.saveUserListenInstitution(userId,institutionId);
			}
			if(questionId1!=null){
				int questionId2 = (int)questionId1;
				long questionId = (long)questionId2;
				responseData = myselfService.saveUserListenQuestion(userId,questionId);
			}
			return responseData;
		}else{
			return responseData;
		}
	}
	/**
	 * 我的收听 根据queryType来查询
	 * @param map
	 * @return
	 */
	@RequestMapping("/listen_list")
	@ResponseBody
	public ResponseData getMyListenList(@RequestBody Map map){
		Byte queryType = null;
		Object queryType1 = map.get("queryType");
		if(queryType1==null){
			queryType=(byte)1;
		}else{
			int queryType2=(int)queryType1;
			queryType=(byte)queryType2;
		}
		Object object = map.get("userId");
		int userId1 = (int)object;
		long userId = (long)userId1;
		int page = (int)map.get("page");
		int pageSize = (int)map.get("pageSize");
		ResponseData responseData = myselfService.getMyListenByQueryType(queryType,userId,page,pageSize);
		return responseData;
	}
	/**
	 * 根据queryType来进行我答列表的分页显示
	 * @param map
	 * @return
	 */
	@RequestMapping("/answer_list")
	@ResponseBody
	public ResponseData getMyAnswerList(@RequestBody Map map){
		Byte queryType = null;
		Object queryType1 = map.get("queryType");
		if(queryType1==null){
			queryType=(byte)1;
		}else{
			int queryType2=(int)queryType1;
			queryType=(byte)queryType2;
		}
		int userId1 = (int)map.get("userId");
		long userId = (long)userId1;
		int page = (int)map.get("page");
		int pageSize = (int)map.get("pageSize");
		ResponseData responseData=myselfService.getMyAnswerList(userId,queryType,page,pageSize);
		return responseData;
	}
}
