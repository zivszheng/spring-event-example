package com.zivs.listener.event;

import com.zivs.bo.UserBean;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
/**
 * 用户注册 event
 * @author zivs.zheng
 * @date 2018/11/1 13:37
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {
    //注册用户对象
    private UserBean user;

    /**
     * 重写构造函数
     *
     * @param source 发生事件的对象
     * @param user   注册用户对象
     */
    public UserRegisterEvent(Object source, UserBean user) {
        super(source);
        this.user = user;
    }
}