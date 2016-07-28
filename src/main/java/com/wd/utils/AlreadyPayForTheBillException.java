package com.wd.utils;

/**
 * Created by Zhipeng on 2016/5/20.
 */
public class AlreadyPayForTheBillException extends Exception {
    public AlreadyPayForTheBillException(){
        super("已经支付过这个账单");
    }
    public AlreadyPayForTheBillException(String s){
        super(s);
    }
}
