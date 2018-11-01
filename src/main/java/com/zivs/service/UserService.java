package com.zivs.service;

import com.zivs.bo.UserBean;
import com.zivs.listener.event.UserCloseEvent;
import com.zivs.listener.event.UserRegisterEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 用户注册/注销服务
 *
 * @Auther: zivs.zheng
 * @Date: 2018/10/31 18:00
 */
@Service
public class UserService {

    @Autowired
    ApplicationContext applicationContext;

    /**
     * 用户注册方法
     *
     * @param user
     */
    public void register(UserBean user) {

        // do something ...

        // 发布UserRegisterEvent事件
        applicationContext.publishEvent(new UserRegisterEvent(this, user));
    }

    /**
     * 用户注册方法
     *
     * @param user
     */
    public void close(UserBean user) {

        // do something ...

        // 发布UserCloseEvent事件
        applicationContext.publishEvent(new UserCloseEvent(this, user));
    }

}