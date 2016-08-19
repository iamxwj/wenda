package com.wd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wd.dao.InvestorInfoDao;
import com.wd.dao.QuestionDao;
import com.wd.dao.QuestionListenDao;
import com.wd.data.ResponseData;
import com.wd.domain.Question;
import com.wd.service.QuestionService;

/**
 * QuestionServiceImpl
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private InvestorInfoDao investorInfoDao;
	@Autowired
	private QuestionListenDao questionListenDao;
//	/**
//	 * 用于获取好问分页
//	 */
//	@Override
//	@Transactional(readOnly=true)
//	public ResponseData getQuestionPage(Byte questionType,int page,int size) {
//		ResponseData responseData = null;
//		if(questionType==null){
//			Page<QuestionEntity> questionPage = questionDao.findAll(new PageRequest(page-1, size));
//			Map<String,Object> map=null;
//			Map<String,Object> map1 = null;
//			List list = new ArrayList<>();
//			
//			if(questionPage!=null){
//				List<QuestionEntity> content = questionPage.getContent();
//				if(content!=null&&content.size()!=0){
//					for (QuestionEntity questionEntity : content) {
//						map = new HashMap<>();
//						Long responseId = questionEntity.getResponseId();
//						if(responseId!=null){
//							InvestorInfoEntity findByInvestorId = investorInfoDao.findByInvestorId(responseId);
//							String investorName = findByInvestorId.getInvestorName();
//							String institutionName = findByInvestorId.getInstitutionName();
//							String investorPosition = findByInvestorId.getInvestorPosition();
//							map.put("answerInstitution", institutionName);
//							map.put("answerPost", investorPosition);
//							map.put("answerName", investorName);
//						}
//						Long questionId = questionEntity.getQuestionId();
//						if(questionId!=null){
//							long numberLister = questionListenDao.getCountByQuestionId(questionId);
//							map.put("numberLister", numberLister);
//						}
//						map.put("questionId", questionEntity.getQuestionId());
//						map.put("img", questionEntity.getVoiceUrl());
//						list.add(map);
//					}
//				}
//				responseData = new ResponseData(true, "获取好问列表", list);
//			}
//			return responseData;
//		}else{
//			Page<QuestionEntity> findByQuestionType = questionDao.findByQuestionType(questionType, new PageRequest(page-1, size));
//			Map<String,Object> map=null;
//			Map<String,Object> map1 = null;
//			List list = new ArrayList<>();
//			
//			if(findByQuestionType!=null){
//				List<QuestionEntity> content = findByQuestionType.getContent();
//				if(content!=null&&content.size()!=0){
//					for (QuestionEntity questionEntity : content) {
//						map = new HashMap<>();
//						Long responseId = questionEntity.getResponseId();
//						if(responseId!=null){
//							InvestorInfoEntity findByInvestorId = investorInfoDao.findByInvestorId(responseId);
//							String investorName = findByInvestorId.getInvestorName();
//							String institutionName = findByInvestorId.getInstitutionName();
//							String investorPosition = findByInvestorId.getInvestorPosition();
//							map.put("answerInstitution", institutionName);
//							map.put("answerPost", investorPosition);
//							map.put("answerName", investorName);
//						}
//						Long questionId = questionEntity.getQuestionId();
//						if(questionId!=null){
//							long numberLister = questionListenDao.getCountByQuestionId(questionId);
//							map.put("numberLister", numberLister);
//						}
//						map.put("questionId", questionEntity.getQuestionId());
//						map.put("img", questionEntity.getVoiceUrl());
//						list.add(map);
//					}
//				}
//				responseData = new ResponseData(true, "获取好问列表", list);
//			}
//			return responseData;
//		}
//	}
//	/**
//	 * 用于搜索好问分页
//	 * @return
//	 */
//	public ResponseData searchQuestionPage(String content,int page,int size){
//		return null;
//	}
	
	
	
	@Override
	public ResponseData getQuestionPage(String questionType,int page, int pagesize) {
		ResponseData responseData = new ResponseData(false, "无问题数据！", null);
		Pageable pageable = new PageRequest(page, pagesize);
		Page<Question> questionList = questionDao.findByQuestionType(questionType, pageable);
		if(questionList!=null){
			responseData.setResult(true);
			responseData.setMessage("查询成功！");
			responseData.setObj(questionList);
		}
		return responseData;
	}


	/**      
	* 方法描述：添加问题/发布悬赏
	* 备注：
	*/
	@Override
	public ResponseData addQuestion(Question question) {
		ResponseData responseData = new ResponseData(false, "发布失败！", null);
		Question newquestion = questionDao.save(question);
		if(newquestion!=null){
			responseData.setResult(true);
			responseData.setMessage("发布成功！");
			responseData.setObj(newquestion);
		}
		return responseData;
	}

	/**      
	* 方法描述：根据问题ID获得问题
	* 备注：
	*/
	@Override
	public ResponseData findByQuestionId(Long questionId) {
		ResponseData responseData = new ResponseData(false, "查询失败！", null);
		List<Question> newquestionList = new ArrayList<Question>();
		Question newquestion = questionDao.findByQuestionId(questionId);
		newquestionList.add(newquestion);
		if(newquestion!=null){
			responseData.setResult(true);
			responseData.setMessage("发布成功！");
			responseData.setObj(newquestionList);
		}
		return responseData;
	}

	/**      
	 * 方法描述：根据回答者ID获得问题
	 * 备注：
	 */
	@Override
	public ResponseData findByResponseId(Long responseId,int page, int pagesize) {
		ResponseData responseData = new ResponseData(false, "查询失败！", null);
		Pageable pageable = new PageRequest(page, pagesize);
		Page<Question> questionList = questionDao.findByResponseId(responseId, pageable);
		if(questionList!=null){
			responseData.setResult(true);
			responseData.setMessage("查询成功！");
			responseData.setObj(questionList);
		}
		return responseData;
	}
	
}
