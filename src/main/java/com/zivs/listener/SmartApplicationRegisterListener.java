package com.zivs.listener;

import com.zivs.bo.UserBean;
import com.zivs.service.UserService;
import com.zivs.listener.event.UserRegisterEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过 implements SmartApplicationListener 方式监听用户注册 event
 *
 * @Auther: zivs.zheng
 * @Date: 2018/11/1 09:15
 */
@Component
public class SmartApplicationRegisterListener implements SmartApplicationListener {
    /**
     * Determine whether this listener actually supports the given event type.
     *
     * @param eventType
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        // 判断event类型，此时处理的是用户注册 event
        return eventType == UserRegisterEvent.class;
    }

    /**
     * Determine whether this listener actually supports the given source type.
     *
     * @param sourceType
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        // 判断 event 资源类型 ，这里处理的是 UserService 的
        return sourceType == UserService.class;
    }

    /**
     * event 时间处理
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 获取注册用户信息
        UserRegisterEvent userRegisterEvent = (UserRegisterEvent) event;
        UserBean user = userRegisterEvent.getUser();

        // do something ...

        System.err.println("SmartApplicationListener  用户名：" + user.getName() + "，密码：" + user.getPassword());
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        // event 执行顺序用，默认0
        return 0;
    }
}
