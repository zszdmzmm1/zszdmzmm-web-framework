package com.aue;

import com.aue.mybatis.AppConfig;
import com.aue.mybatis.po.User;
import com.aue.mybatis.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(AppConfig.class)
public class MybatisTest {
    @Autowired
    public UserService userService;

    @AfterEach
    public void reset() {
        userService.truncate();
    }


    @Test
    @DisplayName("测试不加事务，数据库添加用户报错后没有回滚，用户被加入数据库")
    public void withoutTransactionTest() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            userService.saveWithoutTransactional(new User("hjf", 1000));
        });

        Assertions.assertEquals("/ by zero", exception.getMessage());
        List<User> userLists = userService.selectUsersByName("hjf");
        Assertions.assertEquals(1, userLists.size());
    }


    @Test
    @DisplayName("测试加事务，数据库添加用户报错后回滚，用户没有被加入数据库")
    public void withTransactionTest() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            userService.saveWithTransactional(new User("hjf", 1000));
        });

        Assertions.assertEquals("/ by zero", exception.getMessage());
        List<User> userLists = userService.selectUsersByName("hjf");
        Assertions.assertEquals(0, userLists.size());
    }

}
