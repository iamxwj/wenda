package com.wd.utils.alipay.android;

import com.wd.utils.alipay.config.AlipayConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public class PayDemoActivity {

    // 商户PID
    public static final String PARTNER = "2088221927698460";
    // 商户收款账号
    public static final String SELLER = "baodu@alibaodu.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALJFcd/fba4htML2tXXHMPh8P2an+ETcADzLZsNb8vriVliCaG5URES1RqR0msPd7oeI2eQGbFuh1F7CooHJriuDOM8SKb5QIpEa3f6iuWaY01T7xmC6K2t3XunM8YM2pl+VmipIrb9ozqPt49b61tnFUcIGYJux/0m8rbvXwv2NAgMBAAECgYEAkLyzNNk5OoyhLz2QnHxJ9SUjcJxlhLq98p4N5AUOZMVI53mRgiomd0ZagYEuemIAnMfuaCUS6t6cBwetWwS8w7m8Yo3kl+UdFcPV3K/f0koUzyRfuNoptbi7JJ0hVOX+N0jDT3xmNe5K1Beunsjp7yeECiJQeFgo9lWBQY4TMmECQQDihCxLu5JzOF5IZ2T6Tieuy43Sg80h93jq7dbnO/UT3I2Mj6VvkXlTthr8DhzuI9gVdgLOJ5I7YU6qXwholPb1AkEAyXmuv7fO2psFW0Rm/Mf58iRBJg+uslljjqBrWaZwMHdSObfWRQq7AI2YRBRFM6vj9gnl16T0RY97b/R05r1dOQJAYqnzqWEgXzOUTbFLmINmYYqkUae7OCpU7u9+BeZlz6rntOv0wW36DO5rPpLfIxNV0bM/cZBm75po62jNftAz6QJAAhcpIQQfOVVycMf86ZKJnWGS63ouLduPlONFOeDoORiD2eV2a7D4z8CoW8x6C1c1PlBL+jjT8ATVGwxGSj6cwQJAFhVaz+plyl7Mcv1ivlB7IX6wleI3chomCcEC9eSuwzl88T5h+dWd4RqNZvLTto3AmRfbA6W33b1NLM39eBIPjA==";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyRXHf322uIbTC9rV1xzD4fD9mp/hE3AA8y2bDW/L64lZYgmhuVEREtUakdJrD3e6HiNnkBmxbodRewqKBya4rgzjPEim+UCKRGt3+orlmmNNU+8Zguitrd17pzPGDNqZflZoqSK2/aM6j7ePW+tbZxVHCBmCbsf9JvK2718L9jQIDAQAB";

    private static final int SDK_PAY_FLAG = 1;

    public static String pay(String subject, String body, String price, Long id){
        String orderInfo = getOrderInfo(subject, body, price,id);

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息，payInfo是android端要传给支付宝的订单信息
         */
         String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
        return payInfo;
    }

    /**
     * create the order info. 创建订单信息
     */
    public static String getOrderInfo(String subject, String body, String price, Long id) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + AlipayConfig.partner + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + AlipayConfig.seller_email + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + id + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + AlipayConfig.direct_pay_notify_url + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

//    /**
//     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
//     */
//    private String getOutTradeNo() {
//        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
//        Date date = new Date();
//        String key = format.format(date);
//
//        Random r = new Random();
//        key = key + r.nextInt();
//        key = key.substring(0, 15);
//        return key;
//    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    public static String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    public static String getSignType() {
        return "sign_type=\"RSA\"";
    }

}
