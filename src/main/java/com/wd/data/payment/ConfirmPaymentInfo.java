package com.wd.data.payment;

import java.util.List;

/**
 * Created by Zhipeng on 2016/5/19.
 */
public class ConfirmPaymentInfo {
    private Long userId;
    private long amount;
    private int operationType;
    private int paymentType;
    private boolean in_out;
    private List<OrderRelativeInfo> relativeInfos;
    private int sourceDevice;

    public ConfirmPaymentInfo() {
    }

    public ConfirmPaymentInfo(Long userId, long amount, int operationType, int paymentType, boolean in_out,
                              List<OrderRelativeInfo> relativeInfos, int sourceDevice) {
        this.userId = userId;
        this.amount = amount;
        this.operationType = operationType;
        this.paymentType = paymentType;
        this.in_out = in_out;
        this.relativeInfos = relativeInfos;
        this.sourceDevice = sourceDevice;
    }

    public int getSourceDevice() {
        return sourceDevice;
    }

    public void setSourceDevice(int sourceDevice) {
        this.sourceDevice = sourceDevice;
    }

    public List<OrderRelativeInfo> getRelativeInfos() {
        return relativeInfos;
    }

    public void setRelativeInfos(List<OrderRelativeInfo> relativeInfos) {
        this.relativeInfos = relativeInfos;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getAmount() {
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

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isIn_out() {
        return in_out;
    }

    public void setIn_out(boolean in_out) {
        this.in_out = in_out;
    }
}
