package com.zivs.web;

import com.zivs.bo.UserBean;
import com.zivs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    //用户业务逻辑实现
    @Autowired
    private UserService userService;

    /**
     * 注册控制方法
     *
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(UserBean user) {
        //调用注册业务逻辑
        userService.register(user);
        return "注册成功.";
    }

    @RequestMapping(value = "/close")
    public String close(UserBean user) {
        //调用注册业务逻辑
        userService.close(user);
        return "注销成功.";
    }
}