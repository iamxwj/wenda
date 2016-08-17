package com.wd.domain;
// Generated 2016-7-13 14:05:07 by Hibernate Tools 5.1.0.Beta1
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserInfo generated by hbm2java
 */

@Entity
@Table(name="question",catalog="wd")
public class Question implements java.io.Serializable {

	
	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	
	
	@Column(name = "requestor_name")
	private String requestorName;
	
	@Column(name = "requestor_img")
	private String requestorImg;
	
	@Column(name = "requestor_institution")
	private String requestorInstitution;
	
	@Column(name = "request_amount")
	private int requestAmount;
	
	@Column(name = "requestor_post")
	private String requestorPost;
	
	@Column(name = "response_post")
	private String responsePost;
	
	@Column(name = "number_listen")
	private int numberListen;
	
	@Column(name = "question_like")
	private int questionLike;
	
	@Column(name = "requestor_id")
	private Long requestorId;
	
	@Column(name = "responser_img")
	private String responserImg;
	
	@Column(name = "responser_name")
	private String responserName;
	
	@Column(name = "responser_listen_number")
	private int responserListenNumber;
	
	@Column(name = "response_institution")
	private String responseInstitution;
	
	@Column(name = "response_level")
	private Byte responseLevel;
	
	@Column(name = "response_id")
	private Long responseId;
	
	@Column(name = "response_date")
	private Date responseDate;
	
	@Column(name = "question_content")
	private String questionContent;
	
	@Column(name = "question_content_vioce")
	private String questionContentVoice;
	
	@Column(name = "question_type")
	private String questionType;
	
	@Column(name = "reward_id")
	private Long rewardId;
	
	@Column(name = "question_state")
	private Byte questionState;
	
	@Column(name = "request_date")
	private Date requestDate;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getRequestorName() {
		return requestorName;
	}

	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}

	public String getRequestorImg() {
		return requestorImg;
	}

	public void setRequestorImg(String requestorImg) {
		this.requestorImg = requestorImg;
	}

	public String getRequestorInstitution() {
		return requestorInstitution;
	}

	public void setRequestorInstitution(String requestorInstitution) {
		this.requestorInstitution = requestorInstitution;
	}

	public int getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(int requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getRequestorPost() {
		return requestorPost;
	}

	public void setRequestorPost(String requestorPost) {
		this.requestorPost = requestorPost;
	}

	public String getResponsePost() {
		return responsePost;
	}

	public void setResponsePost(String responsePost) {
		this.responsePost = responsePost;
	}

	public int getNumberListen() {
		return numberListen;
	}

	public void setNumberListen(int numberListen) {
		this.numberListen = numberListen;
	}

	public int getQuestionLike() {
		return questionLike;
	}

	public void setQuestionLike(int questionLike) {
		this.questionLike = questionLike;
	}

	public Long getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}

	public String getResponserImg() {
		return responserImg;
	}

	public void setResponserImg(String responserImg) {
		this.responserImg = responserImg;
	}

	public String getResponserName() {
		return responserName;
	}

	public void setResponserName(String responserName) {
		this.responserName = responserName;
	}

	public int getResponserListenNumber() {
		return responserListenNumber;
	}

	public void setResponserListenNumber(int responserListenNumber) {
		this.responserListenNumber = responserListenNumber;
	}

	public String getResponseInstitution() {
		return responseInstitution;
	}

	public void setResponseInstitution(String responseInstitution) {
		this.responseInstitution = responseInstitution;
	}

	public Byte getResponseLevel() {
		return responseLevel;
	}

	public void setResponseLevel(Byte responseLevel) {
		this.responseLevel = responseLevel;
	}

	public Long getResponseId() {
		return responseId;
	}

	public void setResponseId(Long responseId) {
		this.responseId = responseId;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionContentVoice() {
		return questionContentVoice;
	}

	public void setQuestionContentVoice(String questionContentVoice) {
		this.questionContentVoice = questionContentVoice;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Long getRewardId() {
		return rewardId;
	}

	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}

	public Byte getQuestionState() {
		return questionState;
	}

	public void setQuestionState(Byte questionState) {
		this.questionState = questionState;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", requestorName=" + requestorName + ", requestorImg="
				+ requestorImg + ", requestorInstitution=" + requestorInstitution + ", requestAmount=" + requestAmount
				+ ", requestorPost=" + requestorPost + ", responsePost=" + responsePost + ", numberListen="
				+ numberListen + ", questionLike=" + questionLike + ", requestorId=" + requestorId + ", responserImg="
				+ responserImg + ", responserName=" + responserName + ", responserListenNumber=" + responserListenNumber
				+ ", responseInstitution=" + responseInstitution + ", responseLevel=" + responseLevel + ", responseId="
				+ responseId + ", responseDate=" + responseDate + ", questionContent=" + questionContent
				+ ", questionContentVoice=" + questionContentVoice + ", questionType=" + questionType + ", rewardId="
				+ rewardId + ", questionState=" + questionState + ", requestDate=" + requestDate + "]";
	}

	
}