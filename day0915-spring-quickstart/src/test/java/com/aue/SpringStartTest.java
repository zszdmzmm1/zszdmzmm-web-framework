package com.aue;

import com.aue.dao.impl.SimpleUserDao;
import com.aue.service.impl.SimpleUserService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStartTest {
    @Test
    @DisplayName("spring容器里存在，不存在哪些bean")
    public void IoCTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Assertions.assertTrue(ac.containsBean("userService"));
        Assertions.assertTrue(ac.containsBean("userDao"));
        Assertions.assertFalse(ac.containsBean("itDoseNotExist"));
        Assertions.assertInstanceOf(SimpleUserService.class, ac.getBean("userService"));
        Assertions.assertInstanceOf(SimpleUserDao.class, ac.getBean("userDao"));
    }

    @Test
    @DisplayName("spring初始化了哪些类型")
    public void IoCTest1() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Assertions.assertInstanceOf(SimpleUserService.class, ac.getBean("userService"));
        Assertions.assertInstanceOf(SimpleUserDao.class, ac.getBean("userDao"));
    }
}
