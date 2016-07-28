package com.wd.utils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

/**
 * Created by Zhipeng on 2016/6/1.
 */
public class XMLObjectParser {
    public static Serializer serializer = new Persister();

    public static <T> T xmlString2Object(T t, String xml) throws Exception{
        return  serializer.read(t,xml);
    }

    public static String Object2XmlString(Object o) throws Exception {
        StringWriter stringWriter = new StringWriter();
        serializer.write(o, stringWriter);
        return stringWriter.toString();
    }
}
