package com.wd.domain;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * QuestionEntity
 *
 * @author xwj
 * @date 2016/08/11
 */
@Entity
@Table(name = "question", schema = "", catalog = "wd")
public class QuestionEntity {
    private Long questionId;
    private Long requestId;
    private Long responseId;
    private int requestAmount;
    private Timestamp responseDate;
    private String voiceUrl;
    private Byte questionType;
    private String questionContent;
    private Timestamp createDate;
    @Column(name = "question_content")
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public QuestionEntity() {
    }

    public QuestionEntity(Long questionId, Long requestId, Long responseId, int requestAmount, Timestamp responseDate,
                          String voiceUrl) {
        this.questionId = questionId;
        this.requestId = requestId;
        this.responseId = responseId;
        this.requestAmount = requestAmount;
        this.responseDate = responseDate;
        this.voiceUrl = voiceUrl;
    }

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Column(name = "request_id")
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Column(name = "response_id")
    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    @Column(name = "request_amount")
    public int getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    @Column(name = "response_date")
    public Timestamp getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Timestamp responseDate) {
        this.responseDate = responseDate;
    }

    @Column(name = "voice_url")
    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    @Column(name = "question_type")
    public Byte getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Byte questionType) {
        this.questionType = questionType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
        result = prime * result + requestAmount;
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
        result = prime * result + ((responseDate == null) ? 0 : responseDate.hashCode());
        result = prime * result + ((responseId == null) ? 0 : responseId.hashCode());
        result = prime * result + ((voiceUrl == null) ? 0 : voiceUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QuestionEntity other = (QuestionEntity) obj;
        if (questionId == null) {
            if (other.questionId != null)
                return false;
        } else if (!questionId.equals(other.questionId))
            return false;
        if (requestAmount != other.requestAmount)
            return false;
        if (requestId == null) {
            if (other.requestId != null)
                return false;
        } else if (!requestId.equals(other.requestId))
            return false;
        if (responseDate == null) {
            if (other.responseDate != null)
                return false;
        } else if (!responseDate.equals(other.responseDate))
            return false;
        if (responseId == null) {
            if (other.responseId != null)
                return false;
        } else if (!responseId.equals(other.responseId))
            return false;
        if (voiceUrl == null) {
            if (other.voiceUrl != null)
                return false;
        } else if (!voiceUrl.equals(other.voiceUrl))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "QuestionEntity [questionId=" + questionId + ", requestId=" + requestId + ", responseId=" + responseId
                + ", requestAmount=" + requestAmount + ", responseDate=" + responseDate + ", voiceUrl=" + voiceUrl
                + ", questionType=" + questionType + "]";
    }

}
