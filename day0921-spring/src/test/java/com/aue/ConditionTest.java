package com.aue;

import com.aue.config.ConditionConfig;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionTest {
    @BeforeEach
    public void resetSystemProperty(){
        System.setProperty("os.name", "Windows 11");
    }
    @Test
    @DisplayName("测试@Condition注解")
    public void windowTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Assertions.assertTrue(ac.containsBean("getWindowEnvironment"));
        Assertions.assertFalse(ac.containsBean("getMacEnvironment"));
    }

    @Test
    @DisplayName("System.setProperty()改变操作系统名字测试非本机操作系统的相关测试")
    public void macTest(){
        System.setProperty("os.name", "macOS");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Assertions.assertFalse(ac.containsBean("getWindowEnvironment"));
        Assertions.assertTrue(ac.containsBean("getMacEnvironment"));
    }
}
