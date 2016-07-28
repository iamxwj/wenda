package com.wd.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Zhipeng on 2016/5/10
 */
@Entity
@Table(name = "user_money_bag_detail", schema = "", catalog = "djt")
public class UserMoneyBagDetailEntity {
    private Long id;
    private Long userId;
    private Long amount;
    private int operationType;
    private Timestamp createDate;
    private String tradeNo;
    private int sourceDevice;
    private String tradeStatus;
    private int paymentType;
    private String buyerEmail;
    private String buyerId;
    private String notifyId;
    private String gmtPayment;
    private boolean outOrIn;
    private String refundStatus;
    private boolean deliveryToUser;
    private Long toUserId;
    private Long fromUserId;

    public UserMoneyBagDetailEntity() {

    }

    public UserMoneyBagDetailEntity(Long userId, Long amount, int operationType, int sourceDevice, int paymentType, boolean outOrin) {
        this.userId = userId;
        this.amount = amount;
        this.operationType = operationType;
        this.sourceDevice = sourceDevice;
        this.paymentType = paymentType;
        this.outOrIn = outOrin;
        this.deliveryToUser = false;
    }

    public UserMoneyBagDetailEntity(Long currentUserId, Long payToUserId, Long fromUserId, Long amount, int operationType, int paymentType, boolean inOut) {
        this.userId = currentUserId;
        this.toUserId = payToUserId;
        this.fromUserId = fromUserId;
        this.amount = amount;
        this.operationType = operationType;
        this.paymentType = paymentType;
        this.outOrIn = inOut;
    }

    @Column(name = "delivery_to_user")
    public boolean isDeliveryToUser() {
        return deliveryToUser;
    }

    public void setDeliveryToUser(boolean deliveryToUser) {
        this.deliveryToUser = deliveryToUser;
    }

    @Column(name = "refund_status")
    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Column(name = "in_out")
    public boolean isOutOrIn() {
        return outOrIn;
    }

    public void setOutOrIn(boolean outOrIn) {
        this.outOrIn = outOrIn;
    }


    @Column(name = "gmt_payment")
    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    @Column(name = "operation_type")
    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }


    @Column(name = "tradeNo")
    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Column(name = "source_device")
    public int getSourceDevice() {
        return sourceDevice;
    }

    public void setSourceDevice(int sourceDevice) {
        this.sourceDevice = sourceDevice;
    }


    @Column(name = "trade_status")
    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    @Column(name = "payment_type")
    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }


    @Column(name = "buyer_email")
    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    @Column(name = "buyer_id")
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @Column(name = "notify_id")
    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
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

    @Column(name = "amount")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    @Column(name = "to_user_id")
    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }
    @Column(name = "from_user_id")
    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Override
    public String toString() {
        return "UserMoneyBagDetailEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                ", operationType=" + operationType +
                ", createDate=" + createDate +
                ", tradeNo='" + tradeNo + '\'' +
                ", sourceDevice=" + sourceDevice +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", paymentType=" + paymentType +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", notifyId='" + notifyId + '\'' +
                ", gmtPayment='" + gmtPayment + '\'' +
                ", outOrIn=" + outOrIn +
                ", refundStatus='" + refundStatus + '\'' +
                ", deliveryToUser=" + deliveryToUser +
                ", toUserId=" + toUserId +
                ", fromUserId=" + fromUserId +
                '}';
    }
}
