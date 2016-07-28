
package com.wd.utils.alidayu;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "model",
    "err_code",
    "success"
})
public class Result {
    @Override
    public String toString() {
        return "Result{" +
                "model='" + model + '\'' +
                ", errCode='" + errCode + '\'' +
                ", success=" + success +
                '}';
    }

    @JsonProperty("model")
    private String model;
    @JsonProperty("err_code")
    private String errCode;
    @JsonProperty("success")
    private Boolean success;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The model
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * 
     * @param model
     *     The model
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 
     * @return
     *     The errCode
     */
    @JsonProperty("err_code")
    public String getErrCode() {
        return errCode;
    }

    /**
     * 
     * @param errCode
     *     The err_code
     */
    @JsonProperty("err_code")
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * 
     * @return
     *     The success
     */
    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 
     * @param success
     *     The success
     */
    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
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
