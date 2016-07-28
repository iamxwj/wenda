
package com.wd.utils.alidayu;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "result",
    "request_id"
})
public class AlibabaAliqinFcSmsNumSendResponse {

    @JsonProperty("result")
    private Result result;
    @JsonProperty("request_id")
    private String requestId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The result
     */
    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
    }

    /**
     * 
     * @return
     *     The requestId
     */
    @JsonProperty("request_id")
    public String getRequestId() {
        return requestId;
    }

    /**
     * 
     * @param requestId
     *     The request_id
     */
    @JsonProperty("request_id")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "AlibabaAliqinFcSmsNumSendResponse{" +
                "requestId='" + requestId + '\'' +
                ", result=" + result +
                '}';
    }
}
