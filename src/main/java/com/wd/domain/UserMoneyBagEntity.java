package com.wd.domain;

import javax.persistence.*;

/**
 * Created by Zhipeng on 2016/5/10.
 */
@Entity
@Table(name = "user_money_bag", schema = "", catalog = "djt")
public class UserMoneyBagEntity {
    private Long id;
    private Long userId;
    private Long amount;

    public UserMoneyBagEntity() {
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
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public UserMoneyBagEntity(Long userId, Long amount) {
        this.userId = userId;
        this.amount = amount;
    }

    @Column(name = "amount")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
