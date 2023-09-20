package com.aue;

import com.aue.config.ProxyBeanConfig;
import com.aue.pojo.Person;
import com.aue.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyBeanTest {
    static ApplicationContext ac;
    @BeforeAll
    public static void beforeTest() {
        ac = new AnnotationConfigApplicationContext(ProxyBeanConfig.class);
    }

    @Test
    @DisplayName("判断已经通过Configuration和Bean注解的方式向Spring IoC容器注册组件")
    public void instanceTest() {
        ProxyBeanConfig beanConfig = ac.getBean(ProxyBeanConfig.class);
        Assertions.assertInstanceOf(Person.class, beanConfig.getPerson());
    }

    @Test
    @DisplayName("对bean起名，同样可以获取, 或者用默认值(方法名)")
    public void beanTest() {
        Assertions.assertNotNull(ac.getBean("getPerson"));
        Assertions.assertNotNull(ac.getBean("userService"));
    }
}
