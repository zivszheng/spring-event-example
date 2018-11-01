package com.zivs.listener;

import com.zivs.bo.UserBean;
import com.zivs.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过 implements ApplicationListener<T> 方式监听用户注册 event
 *
 * @Auther: zivs.zheng
 * @Date: 2018/11/1 09:10
 */
@Component
public class ApplicationRegisterListener implements ApplicationListener<UserRegisterEvent> {
    /**
     * Handle an application event.
     *
     * @param userRegisterEvent the event to respond to
     */
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        // 获取到注册用户信息
        UserBean user = userRegisterEvent.getUser();

        // do something ...

        System.err.println("ApplicationListener  用户名："+user.getName()+"，密码："+user.getPassword());

    }
}
