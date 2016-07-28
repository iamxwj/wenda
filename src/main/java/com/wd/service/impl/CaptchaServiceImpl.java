/*
 * @(#)CaptchaServiceImpl.java, 2015/11/9.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service.impl;

import com.wd.service.CaptchaService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * CaptchaServiceImpl
 *
 * @author HOU Zhipeng
 * @date 2016/06/12
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    private static Logger logger = Logger.getLogger(CaptchaServiceImpl.class);

    public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";//放到session中的key
    private Random random = new Random();
    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串

    private int width = 80;//图片宽
    private int height = 26;//图片高
    private int lineSize = 40;//干扰线数量
    private int stringNum = 4;//随机产生字符数量
    /*
     * 获得字体
     */
    private Font getFont(){
        return new Font("Fixedsys",Font.CENTER_BASELINE,18);
    }
    /*
     * 获得颜色
     */
    private Color getRandColor(int fc,int bc){
        if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc-fc-16);
        int g = fc + random.nextInt(bc-fc-14);
        int b = fc + random.nextInt(bc-fc-18);
        return new Color(r,g,b);
    }
    /**
     * 生成随机图片
     */
    @Override
    public void setCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        //BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();//产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman",Font.ROMAN_BASELINE,18));
        g.setColor(getRandColor(110, 133));
        //绘制干扰线
        for(int i=0;i<=lineSize;i++){
            drowLine(g);
        }
        //绘制随机字符
        String randomString = "";
        for(int i=1;i<=stringNum;i++){
            randomString=drowString(g,randomString,i);
        }
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        System.out.println(randomString);
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());//将内存中的图片通过流动形式输出到客户端
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validateCaptcha(String captchaStr, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String rightCaptcha = (String) session.getAttribute(RANDOMCODEKEY);

        logger.info("rightCaptcha = " + rightCaptcha + "; captchaStr = " + captchaStr);
        if(captchaStr != null && captchaStr.equalsIgnoreCase(rightCaptcha))
            return true;
        return false;
    }

    /*
     * 绘制字符串
     */
    private String drowString(Graphics g,String randomString,int i){
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101),random.nextInt(111),random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString +=rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13*i, 16);
        return randomString;
    }
    /*
     * 绘制干扰线
     */
    private void drowLine(Graphics g){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x+xl, y+yl);
    }
    /*
     * 获取随机的字符
     */
    public String getRandomString(int num){
        return String.valueOf(randString.charAt(num));
    }
}

//    private ImageCaptchaService captchaService = new DefaultManageableImageCaptchaService(
//            new FastHashMapCaptchaStore(), new CaptchaEngine(), 180, 100000, 75000);
//
//    @Override
//    public byte[] getCaptchaImageByteArray(String captchaId) {
//        //创建一个字节数组输出流实例
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//
//        try {
//            // 利用验证码生成类生成验证码的缓存图片实例
//            BufferedImage challenge = captchaService.getImageChallengeForID(captchaId);
//            // JPEG图片编码器
//            JPEGImageEncoder jpegImageEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
//            jpegImageEncoder.encode(challenge);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        // 返回图片验证码的字节数组
//        return jpegOutputStream.toByteArray();
//    }
//
//    @Override
//    public boolean validateCaptcha(String captchaId, String inputCaptcha) {
//        return true;
//       // return captchaService.validateResponseForID(captchaId, inputCaptcha);
//    }
//}