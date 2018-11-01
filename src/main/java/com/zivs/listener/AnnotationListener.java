package com.zivs.listener;

import com.zivs.bo.UserBean;
import com.zivs.listener.event.UserCloseEvent;
import com.zivs.listener.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 通过 <code>@EventListener</code> 方式监听用户注册/注销 event
 * @author zivs.zheng
 * @date 2018/11/1 13:38
 */
@Component
public class AnnotationListener {

    /**
     * 注册监听实现方法
     *
     * @param event 用户注册事件
     */
    @EventListener
    public void register(UserRegisterEvent event) {
        // 获取用户对象
        UserBean user = event.getUser();

        // do something ...

        System.err.println("UserRegisterEvent  用户名：" + user.getName() + "，密码：" + user.getPassword());
    }


    /**
     * 注销监听实现方法
     *
     * @param event 用户注销事件
     */
    @EventListener
    @Async // 异步处理
    public void close(UserCloseEvent event) {
        // 获取用户对象
        UserBean user = event.getUser();

        // do something ...

        System.err.println("UserCloseEvent  用户名：" + user.getName() + "，密码：" + user.getPassword());
    }
}