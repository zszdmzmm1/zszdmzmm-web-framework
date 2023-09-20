package com.aue;

import com.aue.config.ProxyBeanConfig;
import com.aue.pojo.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(ProxyBeanConfig.class)
public class SpringTest {
    @Autowired
    ApplicationContext ac;

    @Autowired
    Person person;

    @Test
    @DisplayName("判断Autowired的组件真的被注入")
    public void test() {
        Assertions.assertNotNull(person);
        Assertions.assertNotNull(ac.getBean("userService"));
        System.out.println(ac.toString());
    }


    @Test
    @DisplayName("看看ac的实现类GenericApplicationContext.class")
    public void test1() {
        Assertions.assertInstanceOf(GenericApplicationContext.class, ac);
    }
}
