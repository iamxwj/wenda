/*
 * @(#)ResponseStatus.java, 2016/1/21.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.data;

/**
 * ResponseData
 *
 * @author chenbin
 * @date 2016/1/21
 */
public class ResponseData {
    public static String NOT_LOGIN = "用户尚未登录";
    public static String CAPTCHA_ERROR = "验证码错误";

    public static String UPLAOD_BASIC_INFO_SUCCESS = "提交基本信息成功";
    public static String UPLOAD_INVESTOR_INTRO_SUCCESS = "上传投资人介绍成功";
    public static String UPLOAD_INVESTOR_INTRO_FAIL = "上传投资人介绍失败";
    public static String UPLOAD_BASIC_INFO_FAIL = "提交基本信息失败";

    public static String UPLOAD_INSTITUTION_MEMBER_SUCCESS = "上传机构成员成功";
    public static String UPLOAD_INSTITUTION_MEMBER_FAIL = "上传机构成员失败";

    public static String INVEST_CASE_NAME_INVALID = "投资案例名称非法";
    public static String INVEST_CASE_INVEST_NUMBER_INVALID = "投资案例投资金额非法";
    public static String UPLOAD_INVEST_CASE_SUCCESS = "上传投资案例成功";
    public static String UPLOAD_INVEST_CASE_FAIL = "上传投资案例失败";

    public static String INVESTOR_PHOTO_INVALID = "未上传投资人头像";

    private boolean result;
    private String message;
    private Object obj;
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "ResponseData [result=" + result + ", message=" + message + ", obj=" + obj + "]";
	}
	public ResponseData(boolean result, String message, Object obj) {
		super();
		this.result = result;
		this.message = message;
		this.obj = obj;
	}

}
