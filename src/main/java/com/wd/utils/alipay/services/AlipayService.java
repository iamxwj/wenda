package com.wd.utils.alipay.services;

import com.wd.utils.alipay.config.AlipayConfig;
import com.wd.utils.alipay.util.AlipaySubmit;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
//http://localhost:8080/directPayTest.jsp?detailId=100&subject=test&alibody=test&total_fee=0.01

/**
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
public class AlipayService {

    private final static String ALIPAY_GATEWAY_OLD = "https://www.alipay.com/cooperate/gateway.do?";

    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";

    public static String create_direct_pay_by_user(Map<String, String> sParaTemp) {

        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("return_url", AlipayConfig.return_url);
        sParaTemp.put("notify_url", AlipayConfig.direct_pay_notify_url);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);

        String strButtonName = "test";

        return AlipaySubmit.buildForm(sParaTemp, ALIPAY_GATEWAY_NEW, "get", strButtonName);
    }

    public static String query_timestamp() throws MalformedURLException,
            DocumentException, IOException {

        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + AlipayConfig.partner;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }
}
