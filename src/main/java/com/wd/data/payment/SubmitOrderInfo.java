package com.wd.data.payment;

import java.util.List;

/**
 * Created by Zhipeng on 2016/5/12.
 */
public class SubmitOrderInfo {

    private Long userId;
    private long amount; //支付的金额
    private int operationType; // 支付的类型
    private int sourceDevice; // 支付来源设备
    private int paymentType; // 支付方式
    private List<OrderRelativeInfo> relativeInfos; // 关联的信息
    private boolean outOrIn; // 对钱包来说是充值还是支出


    public SubmitOrderInfo() {
    }

    public boolean isOutOrIn() {
        return outOrIn;
    }

    public void setOutOrIn(boolean outOrIn) {
        this.outOrIn = outOrIn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public int getSourceDevice() {
        return sourceDevice;
    }

    public void setSourceDevice(int sourceDevice) {
        this.sourceDevice = sourceDevice;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderRelativeInfo> getRelativeInfos() {
        return relativeInfos;
    }

    public void setRelativeInfos(List<OrderRelativeInfo> relativeInfos) {
        this.relativeInfos = relativeInfos;
    }
}
