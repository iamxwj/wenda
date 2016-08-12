package com.wd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QuestionListenEntity
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@Entity
@Table(name="question_listen",schema="",catalog="wd")
public class QuestionListenEntity {
	private Long questionListenId;
	private Long userId;
	private Long questionId;
	
	public QuestionListenEntity() {
	}
	
	public QuestionListenEntity(Long questionListenId, Long userId, Long questionId) {
		this.questionListenId = questionListenId;
		this.userId = userId;
		this.questionId = questionId;
	}
	
	@Id
	@Column(name="question_listen_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getQuestionListenId() {
		return questionListenId;
	}

	public void setQuestionListenId(Long questionListenId) {
		this.questionListenId = questionListenId;
	}
	
	@Column(name="user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="question_id")
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	
}
