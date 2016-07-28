
package com.wd.utils.alidayu;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "alibaba_aliqin_fc_sms_num_send_response"
})
public class AliResponse {
    @Override
    public String toString() {
        return "AliResponse{" +
                "alibabaAliqinFcSmsNumSendResponse=" + alibabaAliqinFcSmsNumSendResponse +
                '}';
    }

    @JsonProperty("alibaba_aliqin_fc_sms_num_send_response")
    private AlibabaAliqinFcSmsNumSendResponse alibabaAliqinFcSmsNumSendResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The alibabaAliqinFcSmsNumSendResponse
     */
    @JsonProperty("alibaba_aliqin_fc_sms_num_send_response")
    public AlibabaAliqinFcSmsNumSendResponse getAlibabaAliqinFcSmsNumSendResponse() {
        return alibabaAliqinFcSmsNumSendResponse;
    }

    /**
     * 
     * @param alibabaAliqinFcSmsNumSendResponse
     *     The alibaba_aliqin_fc_sms_num_send_response
     */
    @JsonProperty("alibaba_aliqin_fc_sms_num_send_response")
    public void setAlibabaAliqinFcSmsNumSendResponse(AlibabaAliqinFcSmsNumSendResponse alibabaAliqinFcSmsNumSendResponse) {
        this.alibabaAliqinFcSmsNumSendResponse = alibabaAliqinFcSmsNumSendResponse;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
