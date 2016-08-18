package com.wd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wd.data.ResponseData;
import com.wd.domain.Question;
import com.wd.service.QuestionService;


/**   
*    
* 项目名称：wenda   
* 类名称：QuestionController   
* 创建人：张华   
* 创建时间：2016年8月17日 下午1:46:50      
* @version    
*    
*/
@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
//	//用于获取好问分页
//	@RequestMapping("/get/{questionType}/{page}/{size}")
//	@ResponseBody
//	public ResponseData getQuestionPage(@PathVariable(value="questionType") Byte questionType,
//			@PathVariable(value="page") Integer page,@PathVariable(value="size") int size
//			){
//		if(page==null||page<=0){
//			page=1;
//		}
//		ResponseData responseData = questionService.getQuestionPage(questionType,page,size);
//		return responseData;
//	}
//	
//	//用于搜索好问分页
//	@RequestMapping("/search/{content}/{page}/{size}")
//	@ResponseBody
//	public ResponseData searchQuestionPage(@PathVariable(value="content") String content,
//			@PathVariable(value="page") Integer page,@PathVariable("size") int size
//			){
//		if(page==null||page<=0){
//			page=1;
//		}
//		ResponseData responseData=null;
//		if(content==null||content==""){
//			responseData = questionService.getQuestionPage(null, page, size);
//		}else{
//			responseData = questionService.searchQuestionPage(content,page,size);
//		}
//		
//		return responseData;
//	}
	
	/**      
	* 方法描述：创建问题，发布悬赏
	* 备注：
	*/
	@RequestMapping("/addQuestion")
	@ResponseBody
	public ResponseData addQuestion(@RequestBody Map map){
		String questionType = (String) map.get("questionType");
		int page = (int) map.get("page");
		int pagesize = (int) map.get("pagesize");
		
		Question question = null;
		ResponseData responseData = questionService.addQuestion(question);
		return responseData;
	}
	
	/**      
	* 方法描述：根据问题类型，分页查询问题
	* 备注：
	*/
	@RequestMapping("/pageQuestionByType")
	@ResponseBody
	public ResponseData pageQuestionByType(String questionType,int page,int pagesize){
		ResponseData responseData = questionService.getQuestionPage(questionType, page, pagesize);
		return responseData;
	}
	
	/**      
	 * 方法描述：根据问题ID获得问题
	 * 备注：
	 */
	@RequestMapping("/findByQuestionId")
	@ResponseBody
	public ResponseData findByQuestionId(Long questionId,Long requestorId,Long responseId){
		questionId = (long) 1;
		ResponseData responseData = questionService.findByQuestionId(questionId);
		return responseData;
	}
	
}
