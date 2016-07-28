package com.wd.utils.alidayu;

/**
 * @author Zhipeng
 * @date 2016/7/25.
 */
public class ResponseResult {
    private String model;
    private String err_code;
    private boolean success;

    public ResponseResult() {
    }

    public ResponseResult(String model, String err_code, boolean success) {
        this.model = model;
        this.err_code = err_code;
        this.success = success;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "model='" + model + '\'' +
                ", err_code='" + err_code + '\'' +
                ", success=" + success +
                '}';
    }
}
