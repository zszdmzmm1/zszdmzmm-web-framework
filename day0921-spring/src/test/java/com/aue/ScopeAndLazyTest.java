package com.aue;

import com.aue.config.ScopeAndLazyConfig;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;


public class ScopeAndLazyTest {
    static ByteArrayOutputStream out;
    @BeforeAll
    public static void setOut(){
        out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
    }

    @BeforeEach
    public void streamReset(){
        out.reset();
    }

/*    @AfterEach
    public void streamReset(){
        out.reset();
    }*/



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

    @Test
    @DisplayName("注解@Bean但未注解@Scope('prototype')在new容器时被调用")
    public void lazyTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        Assertions.assertEquals("ScopeAndLazyConfig.getPerson1" + System.lineSeparator(), out.toString());
        ac.getBean("getPerson");
        Assertions.assertEquals("ScopeAndLazyConfig.getPerson1" + System.lineSeparator() + "ScopeAndLazyConfig.getPerson" + System.lineSeparator(), out.toString());
    }

    @Test
    @DisplayName("注解@Bea且注解@Scope('prototype')在new容器时不会被调用")
    public void lazyTest1() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        ac.getBean("getPerson1");
        Assertions.assertEquals("ScopeAndLazyConfig.getPerson1" + System.lineSeparator(), out.toString());
    }

    @Test
    @DisplayName("注解@Bea且注解@lazy只有在new容器时会被调用")
    public void lazyTest2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        ac.getBean("getPerson2");
        Assertions.assertEquals("ScopeAndLazyConfig.getPerson1" + System.lineSeparator() + "ScopeAndLazyConfig.getPerson2" + System.lineSeparator(), out.toString());
    }

    @Test
    @DisplayName("注解@Bea且注解@lazy依旧是单例")
    public void lazyTest3() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ScopeAndLazyConfig.class);
        Assert.assertSame(ac.getBean("getPerson2"),ac.getBean("getPerson2"));
    }
}
