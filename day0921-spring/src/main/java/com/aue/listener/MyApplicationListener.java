package com.aue.listener;

import org.springframework.context.ApplicationListener;

/*  实现ApplicationListener<E extends ApplicationEvent>
    泛型写需要监听的类，实现方法写事件发生时的操作
    */
public class MyApplicationListener implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent event) {
        MyEventSource source =(MyEventSource) event.getSource();
        System.out.println("用户名:" + source.getName() + System.lineSeparator() + "密码:" + source.getPassword());
    }
}
