package com.aue;

import com.aue.mybatis.AppConfig;
import com.aue.mybatis.mapper.BlogListMapper;
import com.aue.mybatis.po.BlogList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(AppConfig.class)
public class MybatisTest {
    @Autowired
    BlogListMapper mapper;

    @Test
    public void selectAllTest() {
        List<BlogList> blogLists = mapper.selectAll();
        Assertions.assertTrue(blogLists.size() > 0);
    }

}
