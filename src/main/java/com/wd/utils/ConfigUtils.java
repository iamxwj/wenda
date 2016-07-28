/*
 * @(#)ConfigUtils.java, 2015/11/16.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * ConfigUtils
 *
 * @author chenbin
 * @date 2015/11/16
 */
public class ConfigUtils {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("app_config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key, null);
    }

    public static List<String> getPropertyAsList(String key) {
        String value = getProperty(key);
        List<String> result = new ArrayList<>();

        if(value != null) {
            return Arrays.asList(value.split("|"));
        }
        return null;
    }
}
