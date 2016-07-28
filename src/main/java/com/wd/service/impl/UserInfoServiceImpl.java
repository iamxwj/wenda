/*
 * @(#)SpringUserDetailServiceImpl.java, 2015/10/28.
 *
 * Copyright 2015 Alibaodu, Inc. All rights reserved.
 * ALIBAODU PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.wd.service.impl;

import com.wd.common.UserType;
import com.wd.dao.*;
import com.wd.data.ResponseData;
import com.wd.data.UserLoginInfo;
import com.wd.data.UserRegisterInfo;
import com.wd.data.ValidResult;
import com.wd.domain.*;
import com.wd.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

/**
 * SpringUserDetailServiceImpl
 *
 * @author chenbin
 * @date 2015/10/28
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private InvestorInfoDao investorInfoDao;

    @Autowired
    private UserMoneyBagDao moneyBagDao;


    // key==> value: username ==> UserInfoEntity
//    private final LoadingCache<String, UserInfoEntity> userInfoEntityCache = CacheBuilder.newBuilder()
//            .maximumSize(CacheConfig.USER_INFO_SIZE)
//            .expireAfterAccess(TimeConstants.DAY_IN_HOUR, TimeUnit.HOURS)
//            .build(new CacheLoader<String, UserInfoEntity>() {
//                @Override
//                public UserInfoEntity load(String username) throws Exception {
//                    return userInfoDao.findByName(username);
//                }
//            });

    @Override
    public ResponseData validateUserPass(HttpServletRequest request, HttpServletResponse response, UserLoginInfo info) {
        if (info == null) {
            String msg = "info == " + info;
            logger.error(msg);
            return new ResponseData(false, msg, null);
        }
        ValidResult valid = info.validateAllFields();
        if (!valid.isValid()) {
            String msg = valid.getMsg();
            logger.error(msg);
            return new ResponseData(false, msg, null);
        }

        try {
            UserInfoEntity userInfoEntity = userInfoDao.findByName(info.getUsername());
            //boolean result = EncryptUtils.checkPassword(info.getPassword(), userInfoEntity.getPassword());
            boolean result = (userInfoEntity.getPassword().equals(info.getPassword())) ? true : false;
            if (result) {
                request.getSession();
                request.changeSessionId();
                setSessionData(request.getSession(), info.getUsername());  // 设置会话数据

                addCookies(request.getSession(), response);  // 添加Cookie
                return new ResponseData(true, "validate username and password success", null);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseData(false, "用户名或密码错误", null);
    }

    @Override
    public void setSessionData(HttpSession httpSession, String username) throws ExecutionException {
        UserInfoEntity userInfoEntity = userInfoDao.findByName(username);

        long userId = userInfoEntity.getUserId();
        httpSession.setAttribute("userId", userId);  // 将UserID写入会话中
        httpSession.setAttribute("username", username);   // 将username写入会话中
        byte userTypeId = userInfoEntity.getUserType();
        httpSession.setAttribute("userTypeId", userTypeId);  // 将用户类型ID写入会话数据
        httpSession.setAttribute("mobile", userInfoEntity.getMobile());
            InvestorInfoEntity investorInfoEntity = investorInfoDao.findByUserId(userId);
            if (investorInfoEntity != null) {
                long investorId = investorInfoEntity.getInvestorId();
                httpSession.setAttribute("id", investorId);  // 将投资人ID写入会话数据
            }

    }

    @Override
    public void addCookies(HttpSession session, HttpServletResponse response) {
        byte userTypeId = (byte) session.getAttribute("userTypeId");
        long id = (long) session.getAttribute("id");

        Cookie userTypeCookie = new Cookie("typeId", String.valueOf(userTypeId));
        userTypeCookie.setPath("/");
        userTypeCookie.setHttpOnly(false);

        Cookie idCookie = new Cookie("id", String.valueOf(id));
        idCookie.setPath("/");
        idCookie.setHttpOnly(false);

        Cookie userIdCookie = new Cookie("userId", String.valueOf(session.getAttribute("userId")));
        userIdCookie.setPath("/");
        userIdCookie.setHttpOnly(false);

        Cookie userNameCookie = new Cookie("username", String.valueOf(session.getAttribute("username")));
        userNameCookie.setPath("/");
        userNameCookie.setHttpOnly(false);

        Cookie mobileCookie = new Cookie("mobile", String.valueOf(session.getAttribute("mobile")));
        mobileCookie.setPath("/");
        mobileCookie.setHttpOnly(false);

        response.addCookie(userTypeCookie);
        response.addCookie(idCookie);
        response.addCookie(userIdCookie);
        response.addCookie(userNameCookie);
        response.addCookie(mobileCookie);
        logger.info("response: " + response);
    }

    @Override
    @Transactional
    public ResponseData addUser(HttpServletRequest request, UserRegisterInfo form) {
        String username = form.getUsername();

        boolean existsName = userInfoDao.existsName(username);
        if (existsName) {
            return new ResponseData(false, "用户名已存在", null);
        }
        String password = form.getPassword();
        byte userType = form.getUserType();

        String email = form.getEmail();
        boolean existsEmail = userInfoDao.existsByEmail(email);
        if (existsEmail) {
            return new ResponseData(false, "邮箱已存在", null);
        }
        String mobile = form.getMobile();
        boolean existsMobile = userInfoDao.existsByMobile(mobile);
        if (existsMobile) {
            return new ResponseData(false, "手机号码已存在", null);
        }
        if (userType < 1 || userType > 3) {
            return new ResponseData(false, "用户类型错误", null);
        }
        UserInfoEntity userInfo = new UserInfoEntity();
        userInfo.setName(username);
        //userInfo.setPassword(EncryptUtils.encodePassword(password));
        userInfo.setPassword(password);
        userInfo.setEmail(email);
        userInfo.setMobile(mobile);
        userInfo.setUserType(userType);

        try {
            UserInfoEntity userInfoEntity = userInfoDao.save(userInfo);

            logger.info("userInfo.userType: " + userType);

                InvestorInfoEntity entity = new InvestorInfoEntity();
                entity.setUserInfoEntity(userInfoEntity);

                investorInfoDao.save(entity);

            setSessionData(request.getSession(), username);
            return new ResponseData(true, "注册成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            return new ResponseData(false, "注册失败", null);
        }
    }


    @Override
    public boolean existsUser(String username) {
        return userInfoDao.existsName(username);
    }

    @Override
    public boolean existsMobile(String mobile) {
        return userInfoDao.existsByMobile(mobile);
    }

    @Override
    public boolean existsEmail(String email) {
        return userInfoDao.existsByEmail(email);
    }

    /**
     * 修改密码
     *
     * @param userLoginInfo
     */
    @Override
    public ResponseData modifyPassword(UserLoginInfo userLoginInfo) {
        try {
            if (validateUserByOldPassword(userLoginInfo)) {
                UserInfoEntity userInfoEntity = userInfoDao.findByName(userLoginInfo.getUsername());
                userInfoEntity.setPassword(userLoginInfo.getNewPassword());
                userInfoDao.save(userInfoEntity);
                return new ResponseData(true, "修改密码成功", null);
            } else {
                return new ResponseData(false, "密码错误", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "修改密码失败", null);
        }
    }

    private boolean validateUserByOldPassword(UserLoginInfo userLoginInfo) {
        String userPassword = userLoginInfo.getPassword();
        String userId = userLoginInfo.getUsername();
        UserInfoEntity userInfoEntity = userInfoDao.findByName(userId);
        String olduserPassword = userInfoEntity.getPassword();
        return userPassword.equals(olduserPassword);
    }


    /**
     * 修改email
     *
     * @param userLoginInfo
     * @return
     */
    @Override
    public ResponseData modifyEmail(UserLoginInfo userLoginInfo) {
        try {
            if (validateUserByOldPassword(userLoginInfo)) {
                UserInfoEntity userInfoEntity = userInfoDao.findByName(userLoginInfo.getUsername());
                userInfoEntity.setEmail(userInfoEntity.getEmail());
                userInfoDao.save(userInfoEntity);
                return new ResponseData(true, "修改email成功", null);
            } else {
                return new ResponseData(false, "密码错误", null);
            }

        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.toString());
            return new ResponseData(false, "修改email失败", null);
        }
    }

    /**
     * 修改Phone
     *
     * @param userLoginInfo
     * @return
     */
    @Override
    public ResponseData modifyPhone(UserLoginInfo userLoginInfo) {
        try {
            if (validateUserByOldPassword(userLoginInfo)) {
                UserInfoEntity userInfoEntity1 = userInfoDao.findByMobile(userLoginInfo.getPhone());
                if (userInfoEntity1 != null) {
                    return new ResponseData(false, "手机号码已经被使用请更改手机号", null);
                }
                UserInfoEntity userInfoEntity = userInfoDao.findByName(userLoginInfo.getUsername());
                userInfoEntity.setMobile(userLoginInfo.getPhone());
                userInfoDao.save(userInfoEntity);
                return new ResponseData(true, "修改Phone成功", null);
            } else {
                return new ResponseData(false, "密码错误", null);
            }

        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.toString());
            return new ResponseData(false, "修改Phone失败", null);
        }
    }

    @Override
    public ResponseData modifyPasswordByVerify(UserLoginInfo userLoginInfo) {
        try {
            UserInfoEntity userInfoEntity = userInfoDao.findByName(userLoginInfo.getUsername());
            userInfoEntity.setPassword(userLoginInfo.getNewPassword());
            userInfoDao.save(userInfoEntity);
            return new ResponseData(true, "修改密码成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(false, "修改密码失败", null);
        }
    }

}
