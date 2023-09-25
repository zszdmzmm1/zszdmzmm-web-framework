package com.aue.listener;

import org.springframework.context.ApplicationEvent;


/*
 * 被监听类继承ApplicationEvent类
 * 需要实现构造方法，source可以是数据来源
 * */
public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source) {
        super(source);
    }
}
