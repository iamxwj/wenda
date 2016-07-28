package com.wd.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Zhipeng on 2016/4/28.
 */
public class TimeUtil {
    private static SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Timestamp date){
        return timeStamp.format(date);
    }
}
