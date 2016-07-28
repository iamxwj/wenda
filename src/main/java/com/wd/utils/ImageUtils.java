/*
 * @(#)ImageUtils.java, 2016/2/26.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.utils;

import com.wd.data.ResponseData;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * ImageUtils
 *
 * @author chenbin
 * @date 2016/2/26
 */
public class ImageUtils {
    private static Logger logger = Logger.getLogger(ImageUtils.class);
    private static String imageServerUrl = ConfigUtils.getProperty("server.image");

    /**
     * 向zimg上传图片文件
     * @param request
     * @return
     */
    public static ResponseData uploadImage(MultipartHttpServletRequest request) {

        // 获取文件map
        Map<String, MultipartFile> files = request.getFileMap();

        // 检查是否包含文件信息
        if (null == files || files.size() == 0) {
            String msg = "http request has no image file";
            logger.error(msg);
            return new ResponseData(false, msg, null);
        }

        // 保存文件至服务器指定路径
        String fileName = null;
        for (String key : files.keySet()) {
            MultipartFile file = files.get(key);
            fileName = file.getOriginalFilename();

            String fileType = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
            logger.debug("image file name is : " + fileName + "; fileType is :　" + fileType);
            byte[] imgData = null;
            try {
                imgData = file.getBytes();
                logger.debug("image data length: " + imgData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String retJson = sendPost(imageServerUrl, imgData, fileType);

            //json解析有很多框架，所以不做参考了
            logger.debug("post result: " + retJson);
            return new ResponseData(true, retJson, null);
        }
        return null;
    }

    /**
     * 向指定url发送POST方法请求
     * @param url 发送请求的url
     * @param postData 请求参数
     * @param fileType 图片文件类型
     * @return 响应结果
     */
    public static String sendPost(String url, byte[] postData, String fileType) {
        OutputStream outStream = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setReadTimeout(50000);
            conn.setConnectTimeout(25000);

            HttpURLConnection httpConn = (HttpURLConnection) conn;
            // 设置通用的请求属性
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("accept", "*/*");
            httpConn.setRequestProperty("Cache-Control", "no-cache");
            httpConn.setRequestProperty("connection", "Keep-Alive");
            httpConn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpConn.setRequestProperty("Content-Type", matchContentType(fileType));

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            httpConn.connect();
            //二进制
            outStream = conn.getOutputStream();

            logger.debug(" begin to upload image to zimg");
            outStream.write(postData);
            outStream.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private static String matchContentType(String fileType){
        String contentType = "image/jpeg";
        switch (fileType) {
            case "bmp":
                contentType = "application/x-bmp";
                break;
            case "img":
                contentType = "application/x-img";
                break;
            case "jpeg":
                contentType = "image/jpeg";
                break;
            case "jpg":
                contentType = "application/x-jpg";
                break;
            case "png":
                contentType = "image/png";
                break;
            default:
                break;
        }
        return contentType;
    }
}
