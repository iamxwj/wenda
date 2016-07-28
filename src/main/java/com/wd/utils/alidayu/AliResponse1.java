
package com.wd.utils.alidayu;

import java.util.HashMap;
import java.util.Map;

public class AliResponse1 {

    private AlibabaAliqinFcSmsNumSendResponse alibabaAliqinFcSmsNumSendResponse;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The alibabaAliqinFcSmsNumSendResponse
     */
    public AlibabaAliqinFcSmsNumSendResponse getAlibabaAliqinFcSmsNumSendResponse() {
        return alibabaAliqinFcSmsNumSendResponse;
    }

    /**
     * 
     * @param alibabaAliqinFcSmsNumSendResponse
     *     The alibaba_aliqin_fc_sms_num_send_response
     */
    public void setAlibabaAliqinFcSmsNumSendResponse(AlibabaAliqinFcSmsNumSendResponse alibabaAliqinFcSmsNumSendResponse) {
        this.alibabaAliqinFcSmsNumSendResponse = alibabaAliqinFcSmsNumSendResponse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
