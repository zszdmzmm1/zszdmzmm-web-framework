package com.aue.config;


import com.aue.dao.UserDao;
import com.aue.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartTimeWithoutAopTest {
    static ByteArrayOutputStream out;

    @BeforeAll
    public static void init() {
        out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
    }

    @BeforeEach
    public void reset() {
        out.reset();
    }

    @Test
    @DisplayName("检测是否输出了运行时的时间")
    public void test() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StartTimeConfig.class);
        UserDaoImpl userDao = ac.getBean(UserDaoImpl.class);
        userDao.creat();
        Assertions.assertTrue(out.toString().contains("startTime"));

        out.reset();

        userDao.retrieve();
        Assertions.assertFalse(out.toString().contains("startTime"));
    }

    @Test
    @DisplayName("加入aop, 检测是否输出了运行时的时间")
    public void test1() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StartTimeAopConfig.class);
        UserDao userDao = ac.getBean(UserDao.class);
        userDao.creat();
        Assertions.assertTrue(out.toString().contains("startTime"));

        out.reset();

        userDao.retrieve();
        Assertions.assertTrue(out.toString().contains("startTime"));
    }


    @Test
    @DisplayName("加入aop, 检测是否输出了运行时的时间")
    public void test2() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StartTimeAopConfig.class);
        UserDao userDao = ac.getBean(UserDao.class);
        userDao.delete();
        Assertions.assertTrue(out.toString().contains("endTime"));

        out.reset();

        userDao.update();
        Assertions.assertTrue(out.toString().contains("endTime"));
    }
}
