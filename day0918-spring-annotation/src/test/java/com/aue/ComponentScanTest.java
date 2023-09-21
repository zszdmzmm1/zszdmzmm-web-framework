package com.aue;

import com.aue.config.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class ComponentScanTest {
    @Test
    @DisplayName("通过配置config，确定扫描的规则，本次测试测试范围")
    public void test(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        Assertions.assertTrue(ac.containsBeanDefinition("userController"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserDao"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserService"));

        //扫描范围外
        Assertions.assertFalse(ac.containsBeanDefinition("componentAnnotationHolder"));
    }

    @Test
    @DisplayName("通过配置config，确定扫描的规则，本次测试测试过滤类后的结果")
    public void test1(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanFilterConfig.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("userController"));

        //被过滤的
        Assertions.assertFalse(ac.containsBeanDefinition("nopeUserDao"));
        Assertions.assertFalse(ac.containsBeanDefinition("nopeUserService"));

    }

    @Test
    @DisplayName("includeFilters 多个匹配")
    public void test2(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig2.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("userController"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserService"));

        //未被选中的
        Assertions.assertFalse(ac.containsBeanDefinition("nopeUserDao"));

    }

    @Test
    @DisplayName("includeFilters basePackages 多个匹配")
    public void test3(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig3.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("userController"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserService"));

        //未被选中的
        Assertions.assertFalse(ac.containsBeanDefinition("nopeUserDao"));

    }

    @Test
    @DisplayName("includeFilters FilterType.REGEX")
    public void test4(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig4.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("userController"));
        Assertions.assertTrue(ac.containsBeanDefinition("noComponentAnnotationController"));

        //未被选中的
        Assertions.assertFalse(ac.containsBeanDefinition("nopeUserDao"));

    }

    @Test
    @DisplayName("includeFilters FilterType.CUSTOM")
    public void test5(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig5.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("userBean"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserDao"));

        //未被选中的
        Assertions.assertFalse(ac.containsBeanDefinition("noComponentAnnotationController"));

    }

    @Test
    @DisplayName("excludeFilter")
    public void test6(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig6.class);
        //被选中的
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserService"));
        Assertions.assertTrue(ac.containsBeanDefinition("nopeUserDao"));

        //未被选中的
        Assertions.assertFalse(ac.containsBeanDefinition("userController"));

    }



}
