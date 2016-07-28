package com.wd.common;

/**
 * 钱包（支付）相关状态
 * Created by Zhipeng on 2016/5/13.
 */
public class PaymentOperationState {
    //操作的类型
    public static final int operation_bag = 1; //钱包
    public static final int operation_advice = 2; //求指教
    public static final int operation_deliery = 3; // 项目投递
    //付款的类型
    public static final int payment_bag = 1; //余额
    public static final int payment_alipay = 2;//支付宝
    public static final int payment_wechat = 3;//微信支付

    //操作来源的设备
    public static final int source_web = 1; //web
    public static final int source_android = 2;// android
    public static final int source_ios = 3;// ios
    //本笔交易是收入还是支出
    public static final boolean bag_operation_in = false; // false 充值
    public static final boolean bag_operation_out = true; // true 支出

    public static final int alipay_success = 1; // 已经付款
    public static final int alipay_noresponse = 2; //未付款
    public static final int alipay_finish = 3; // 已退款


    public static final String alipay_trade_status_wait_pay = "WAIT_BUYER_PAY";
    public static final String alipay_trade_status_trade_closed = "TRADE_CLOSED";
    public static final String alipay_trade_status_trade_success = "TRADE_SUCCESS";
    public static final String alipay_trade_status_trade_pending = "TRADE_PENDING";
    public static final String alipay_trade_status_trade_finished = "TRADE_FINISHED";

}
