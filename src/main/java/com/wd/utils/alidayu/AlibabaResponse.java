package com.wd.utils.alidayu;

/**
 * @author Zhipeng
 * @date 2016/7/25.
 */
public class AlibabaResponse {
    private ResponseResult result;
    private String request_id;

    public AlibabaResponse() {
    }

    public AlibabaResponse(ResponseResult result, String request_id) {
        this.result = result;
        this.request_id = request_id;
    }

    public ResponseResult getResult() {

        return result;
    }

    public void setResult(ResponseResult result) {
        this.result = result;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    @Override
    public String toString() {
        return "AlibabaResponse{" +
                "result=" + result +
                ", request_id='" + request_id + '\'' +
                '}';
    }
}
