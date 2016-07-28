/*
 * @(#)EncryptUtils.java, 2015/10/27.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.utils;

import com.wd.constant.SystemConstants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * EncryptUtils
 *
 * @author chenbin
 * @date 2015/10/27
 */
public class EncryptUtils {
    private static final String PASSWORD_SEPERATOR = "|";

    /**
     * 根据原始密码和Salt生成一个不可逆的密文
     * @param rawPassword
     * @return
     */
    public static String encodePassword(String rawPassword) {
        String salt = generateSalt();
        return encodePassword(rawPassword, salt);
    }

    /**
     * 验证密码是否正确
     * @param rawPassword : 用户传输到后台的密码
     * @param password ：存储在系统中的密文
     * @return
     */
    public static boolean checkPassword(String rawPassword, String password) {
        int index = password.indexOf(PASSWORD_SEPERATOR);
        if(index < 0) {
            return false;
        }
        String salt = password.substring(index + 1);
        return password.equals(encodePassword(rawPassword, salt));
    }


    private static String encodePassword(String rawPassword, String salt) {
        return getBase64MD5(rawPassword + salt) + PASSWORD_SEPERATOR + salt;
    }


    private static String generateSalt() {
        return getBase64MD5(String.valueOf(Math.random()) + String.valueOf(Math.random()));
    }

    /**
     * 返回一个Base64编码的MD5值
     * @param str
     * @return
     */
    public static String getBase64MD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes(SystemConstants.SYSTEM_ENCODING));
            String md5Sum = new sun.misc.BASE64Encoder().encode(md.digest());
            return md5Sum;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
