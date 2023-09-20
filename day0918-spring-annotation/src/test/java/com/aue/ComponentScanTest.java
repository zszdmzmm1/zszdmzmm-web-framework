package com.aue;

import com.aue.config.ComponentScanConfig;
import com.aue.config.ComponentScanFilterConfig;
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
}
