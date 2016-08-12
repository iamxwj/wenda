package com.wd.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.String;

/**
 * @author Zhipeng
 * @date 2016/6/13.
 */
@Document(indexName = "djt", type = "institution")
public class InstitutionDocument {
    @Field(analyzer = "ik", searchAnalyzer = "ik")
    private String institutionName;

    @Field(analyzer = "english", searchAnalyzer = "english")
    private String institutionNameEng;

    @Id
    private Long institutionId;
    @Field(type = String, store = true, analyzer = "ik", searchAnalyzer = "ik")
    private List<String> institutionMemberNames;

    public InstitutionDocument() {
    }

    public InstitutionDocument(String institutionName, Long institutionId) {
        this.institutionName = institutionName;
        this.institutionId = institutionId;
    }

    public InstitutionDocument(String institutionName, Long institutionId, List<String> institutionMemberNames) {
        this.institutionName = institutionName;
        this.institutionId = institutionId;
        this.institutionMemberNames = institutionMemberNames;
    }

    public InstitutionDocument(java.lang.String institutionName, java.lang.String institutionNameEng,
                               Long institutionId, List<java.lang.String> institutionMemberNames) {
        this.institutionName = institutionName;
        this.institutionNameEng = institutionNameEng;
        this.institutionId = institutionId;
        this.institutionMemberNames = institutionMemberNames;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public List<String> getInstitutionMemberNames() {
        return institutionMemberNames;
    }

    public void setInstitutionMemberNames(List<String> institutionMemberNames) {
        this.institutionMemberNames = institutionMemberNames;
    }

    @Override
    public java.lang.String toString() {
        return "InstitutionDocument{" +
                "name='" + institutionName + '\'' +
                ", institutionId=" + institutionId +
                ", memberNames=" + institutionMemberNames +
                '}';
    }
}
