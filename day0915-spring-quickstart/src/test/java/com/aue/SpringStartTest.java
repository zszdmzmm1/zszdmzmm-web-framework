package com.aue;

import com.aue.dao.impl.SimpleUserDao;
import com.aue.service.impl.InitAndDestroyInterfaceUserService;
import com.aue.service.impl.InitAndDestroyUserService;
import com.aue.service.impl.InitAndDestroyXMLUserService;
import com.aue.service.impl.SimpleUserService;
import org.junit.jupiter.api.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStartTest {
    static ClassPathXmlApplicationContext ac;

    @BeforeAll
    public static void beforeTest() {
        ac = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    @DisplayName("spring容器里存在，不存在哪些bean")
    public void ioCTest() {
        Assertions.assertTrue(ac.containsBean("userService"));
        Assertions.assertTrue(ac.containsBean("userDao"));
        Assertions.assertFalse(ac.containsBean("itDoseNotExist"));
        Assertions.assertInstanceOf(SimpleUserService.class, ac.getBean("userService"));
        Assertions.assertInstanceOf(SimpleUserDao.class, ac.getBean("userDao"));
    }

    @Test
    @DisplayName("spring初始化了哪些类型")
    public void ioCTest1() {
        Assertions.assertInstanceOf(SimpleUserService.class, ac.getBean("userService"));
        Assertions.assertInstanceOf(SimpleUserDao.class, ac.getBean("userDao"));
    }

    @Test
    @DisplayName("通过配置文件与setter方法向容器注入依赖")
    public void diTest() {
        SimpleUserService simpleUserService = (SimpleUserService) ac.getBean("userService");
        SimpleUserService simpleUserService1 = (SimpleUserService) ac.getBean("userService1");
        Assertions.assertNull(simpleUserService.getUserDao());
        Assertions.assertInstanceOf(SimpleUserDao.class, simpleUserService1.getUserDao());
    }

    @Test
    @DisplayName("通过配置文件与构造方法向容器注入依赖")
    public void dITest1() {
        SimpleUserService simpleUserService = (SimpleUserService) ac.getBean("userService2");
        Assertions.assertInstanceOf(SimpleUserDao.class, simpleUserService.getUserDao());
    }

    @Test
    @DisplayName("只写了init和destroy方法，不做处理，无法被调用")
    public void initAndDestroyTest1() {
        InitAndDestroyUserService userService3 = (InitAndDestroyUserService) ac.getBean("userService3");
        //控制台未打出InitAndDestroyUserService.init, InitAndDestroyUserService.destroy
        Assertions.assertFalse(false);
    }

    @Test
    @DisplayName("只写了init和destroy方法，配置中加入指定方法, 控制台打出InitAndDestroyUserService.init, InitAndDestroyUserService.destroy")
    public void initAndDestroyTest2() {
        InitAndDestroyXMLUserService userService4 = (InitAndDestroyXMLUserService) ac.getBean("userService4");
        //控制台打出InitAndDestroyUserService.init, InitAndDestroyUserService.destroy
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("实现InitializingBean与DisposableBean接口, 控制台打出InitAndDestroyInterfaceUserService.init, InitAndDestroyInterfaceUserService.destroy")
    public void initAndDestroyTest3() {
        InitAndDestroyInterfaceUserService userService5 =(InitAndDestroyInterfaceUserService) ac.getBean("userService5");
        //控制台打出InitAndDestroyInterfaceUserService.init, InitAndDestroyInterfaceUserService.destroy
        Assertions.assertTrue(true);
    }



    @AfterAll
    public static void afterTest() {
        ac.close();
    }
}
