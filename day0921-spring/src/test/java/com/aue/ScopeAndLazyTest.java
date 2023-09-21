package com.aue;

import com.aue.config.ScopeAndLazyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeAndLazyTest {
    @Test
    @DisplayName("@Scope('prototype') 非单例")
    public void scopeTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        Assertions.assertNotSame(ac.getBean("getPerson"), ac.getBean("getPerson"));
    }

    @Test
    @DisplayName("@Scope('singleton') 单例")
    public void scopeTest1() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        Assertions.assertSame(ac.getBean("getPerson1"), ac.getBean("getPerson1"));
    }
}
