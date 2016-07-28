package com.wd.utils.alipay.config;

/* *
 **类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.2
 *日期：2011-03-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

import com.wd.utils.alipay.util.UtilDate;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088221927698460";
    // 交易安全检验码，由数字和字母组成的32位字符串
    public static String key = "dcvv3qp0drpzo360ebfta8e52inyulgr";

    public static String seller_email = "baodu@alibaodu.com";

    public static String uat_domain_url = "http://211.149.216.28";

    public static String prod_domain_url = "http://www.touzidaren.com";

    public static String in_use_url = uat_domain_url;

    public static String url_port = ":8080";

    public static String direct_pay_notify_url = in_use_url + url_port + "/web/payment/handle_reply";

    public static String refund_notify_url = in_use_url + url_port + "/web/payment/handle_refund";

    public static String return_url = in_use_url + "/#/paymentStatus";

    public static String log_path = "D:\\alipay_log_" + System.currentTimeMillis() + ".txt";

    public static String input_charset = "UTF-8";

    public static String sign_type = "MD5";

    public static String transport = "http";

    public static String refund_service = "refund_fastpay_by_platform_pwd";

    public static String refund_date = UtilDate.getDateFormatter();
}
