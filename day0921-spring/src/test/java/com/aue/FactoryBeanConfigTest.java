package com.aue;


import com.aue.config.CustomFactoryBean;
import com.aue.config.FactoryBeanConfig;
import com.aue.pojo.Apple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanConfigTest {
    @Test
    @DisplayName("存在通过CustomFactoryBean生产的bean与factory工厂本身两个bean")
    public void factoryBeanTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        Assertions.assertTrue(ac.containsBean("customFactoryBean"));
        Assertions.assertTrue(ac.containsBean("&customFactoryBean"));
        Assertions.assertInstanceOf(Apple.class, ac.getBean("customFactoryBean"));
        Assertions.assertInstanceOf(CustomFactoryBean.class, ac.getBean("&customFactoryBean"));
    }


}
