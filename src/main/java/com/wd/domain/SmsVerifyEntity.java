package com.wd.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Zhipeng
 * @date 2016/7/22.
 */
@Entity
@Table(name = "sms_verify", catalog = "djt")
public class SmsVerifyEntity {
    private Long smsId;
    private Long phone;
    private int code;
    private Timestamp createDate;

    public SmsVerifyEntity() {
    }

    public SmsVerifyEntity(Long phone, int code) {
        this.phone = phone;
        this.code = code;
    }

    @Id
    @Column(name = "sms_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getSmsId() {
        return smsId;
    }

    public void setSmsId(Long smsId) {
        this.smsId = smsId;
    }

    @Column
    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Column
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
