package com.wd.utils;

/**
 * Created by Zhipeng on 2016/5/17.
 */
public class RelativeRecordException extends  Exception {
    public RelativeRecordException(){
        super("关联信息不存在");
    }
    public RelativeRecordException(String s){
        super(s);
    }
}
