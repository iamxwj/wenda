package com.wd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Zhipeng on 2016/6/7.
 */
public class JSONUtil {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static <T> String ObjectToJSONString(T t) throws JsonProcessingException {
        return objectMapper.writeValueAsString(t);
    }

    public static <T> T JSONStringToObject(String json, Class<T> tClass) throws IOException {
        return objectMapper.readValue(json,tClass);
    }
}
