package com.aue;

import com.aue.mybatis.AppConfig;
import com.aue.mybatis.mapper.UserMapper;
import com.aue.mybatis.po.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(AppConfig.class)
public class MybatisTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void selectAllTest() {
        List<User> userLists = mapper.selectUserByName("hjf");
        Assertions.assertTrue(userLists.size() > 0);
    }

}
