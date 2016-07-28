package com.wd.data.payment;

/**
 * Created by Zhipeng on 2016/5/12.
 */
public class OrderRelativeInfo {
    private Long id; // OrderRelativeInfo 的 Id，
    private Long relativeId; // 关联的求指教或者 项目投递的Id,
    private Long amount; // 此求指教 或项目投递的金额

    public OrderRelativeInfo() {
    }

    public OrderRelativeInfo(Long relativeId, Long amount) {
        this.relativeId = relativeId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelativeId() {
        return relativeId;
    }

    public void setRelativeId(Long relativeId) {
        this.relativeId = relativeId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderRelativeInfo{" +
                "id=" + id +
                ", relativeId=" + relativeId +
                ", amount=" + amount +
                '}';
    }
}
