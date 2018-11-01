package com.zivs;

import com.zivs.bo.UserBean;
import com.zivs.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试类
 *
 * @Auther: zivs.zheng
 * @Date: 2018/11/1 14:10
 */
public class UserServiceTest extends ApplicationTest {
    @Autowired
    private UserService service;


    @Test
    public void register() {
        UserBean user = new UserBean();
        user.setName("萧炎");
        user.setPassword("123456");
        service.register(user);
    }

    @Test
    public void close() {
        UserBean user = new UserBean();
        user.setName("武庚");
        user.setPassword("123456");
        service.close(user);
    }
}
