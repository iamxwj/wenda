package com.wd.domain.es;

/**
 * Created by Zhipeng on 2016/6/8.
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "wd", type = "investor")
public class InvestorDocument {
    @Id
    private Long investorId;
    @Field(analyzer = "ik",searchAnalyzer = "ik")
    private String investorName;
    @Field(analyzer = "ik",searchAnalyzer = "ik")
    private String institutionName;
    @Field(analyzer = "ik",searchAnalyzer = "ik")
    private String investorPosition;
    public InvestorDocument() {
    }

    public InvestorDocument(Long investorId, String investorName, String institutionName, String investorPosition) {
        this.investorId = investorId;
        this.investorName = investorName;
        this.institutionName = institutionName;
        this.investorPosition = investorPosition;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInvestorPosition() {
        return investorPosition;
    }

    public void setInvestorPosition(String investorPosition) {
        this.investorPosition = investorPosition;
    }

    @Override
    public String toString() {
        return "InvestorDocument{" +
                "investorId=" + investorId +
                ", investorName='" + investorName + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", investorPosition='" + investorPosition + '\'' +
                '}';
    }
}
