package com.wd.domain;

import javax.persistence.*;

/**
 * Created by Zhipeng on 2016/5/13.
 */
@Entity
@Table(name = "user_money_bag_detail_relative", schema = "", catalog = "wd")
public class UserMoneyBagDetailRelativeEntity {
    private Long id;
    private Long refId;
    private double amount;
    private Long relativeId;

    public UserMoneyBagDetailRelativeEntity() {
    }

    public UserMoneyBagDetailRelativeEntity(Long refId, double amount, Long relativeId) {
        this.refId = refId;
        this.amount = amount;
        this.relativeId = relativeId;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "ref_id")
    public Long getRefId() {
        return refId;
    }

    public void setRefId(Long refId) {
        this.refId = refId;
    }
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Column(name = "relative_id")
    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }

}
