package com.wd.data.document;

/**
 * Created by Zhipeng on 2016/6/7.
 */
public class QiNiuResponseInfo {
    private String hash;
    private String key;
    private String code;
    private String error;

    public QiNiuResponseInfo() {
    }

    public QiNiuResponseInfo(String hash, String key, String code, String error) {
        this.hash = hash;
        this.key = key;
        this.code = code;
        this.error = error;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
