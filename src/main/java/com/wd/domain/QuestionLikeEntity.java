package com.wd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QuestionLikeEntity
 * 
 * @author xwj
 * @version 创建时间：2016年8月11日
*/
@Entity
@Table(name="question_like",schema="",catalog="wd")
public class QuestionLikeEntity {
	private Long questionLikeId;
	private Long userId;
	private Long questionId;
	
	public QuestionLikeEntity() {
	}

	public QuestionLikeEntity(Long questionLikeId, Long userId, Long questionId) {
		this.questionLikeId = questionLikeId;
		this.userId = userId;
		this.questionId = questionId;
	}
	
	@Id
	@Column(name="question_like_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getQuestionLikeId() {
		return questionLikeId;
	}

	public void setQuestionLikeId(Long questionLikeId) {
		this.questionLikeId = questionLikeId;
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
