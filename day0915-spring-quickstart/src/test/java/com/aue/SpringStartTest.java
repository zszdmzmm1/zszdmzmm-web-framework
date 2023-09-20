package com.aue;

import com.aue.dao.UserDao;
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

    @Test
    @DisplayName("通过配置文件与setter方法向容器注入依赖")
    public void DITest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        SimpleUserService simpleUserService = (SimpleUserService) ac.getBean("userService");
        SimpleUserService simpleUserService1 = (SimpleUserService) ac.getBean("userService1");
        Assertions.assertNull(simpleUserService.getUserDao());
        Assertions.assertInstanceOf(SimpleUserDao.class, simpleUserService1.getUserDao());
    }
}
