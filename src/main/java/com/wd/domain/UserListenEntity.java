package com.wd.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserListenEntity
 * 
 * @author xwj
 * @version 创建时间：2016年8月18日
*/
@Entity
@Table(name="user_listen",catalog="wd")
public class UserListenEntity {
	
	@Id
	@Column(name="user_listen_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userListenId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="institution_id")
	private Long institutionId;
	
	@Column(name="investor_id")
	private Long investorId;
	
	@Column(name="question_id")
	private Long questionId;

	public UserListenEntity(Long userListenId, Long userId, Long institutionId, Long investorId, Long questionId) {
		this.userListenId = userListenId;
		this.userId = userId;
		this.institutionId = institutionId;
		this.investorId = investorId;
		this.questionId = questionId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getUserListenId() {
		return userListenId;
	}

	public void setUserListenId(Long userListenId) {
		this.userListenId = userListenId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public Long getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}

	public UserListenEntity() {
	}

	public UserListenEntity(Long userListenId, Long userId, Long institutionId, Long investorId) {
		this.userListenId = userListenId;
		this.userId = userId;
		this.institutionId = institutionId;
		this.investorId = investorId;
	}
	
}
