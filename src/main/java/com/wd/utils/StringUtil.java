package com.wd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhipeng on 2016/4/30.
 */
public class StringUtil {
    public static List<String> renderStringToList(String investPhase, String s) {
        if (investPhase.equals(""))
            return null;
        if (investPhase == null) {
            return null;
        }
        String[] string = investPhase.split(s);

        List<String> list = new ArrayList<>();
        for (String i : string) {
            list.add(i);
        }
        return list;
    }

    public static String renderListToString(List<String> list){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        for(String s : list){
            stringBuffer.append(s);
            stringBuffer.append("|");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}
