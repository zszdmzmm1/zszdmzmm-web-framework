package com.aue.config;


import com.aue.dao.UserDao;
import com.aue.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartTimeWithoutAopTest {
    @Test
    @DisplayName("检测是否输出了运行时的时间")
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StartTimeAopConfig.class);
        UserDao userDao = ac.getBean(UserDao.class);
        userDao.creat();
        Assertions.assertTrue(out.toString().contains("startTime"));

        out.reset();

        userDao.retrieve();
        Assertions.assertTrue(out.toString().contains("startTime"));
    }
}
