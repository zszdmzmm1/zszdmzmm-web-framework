package com.aue;

import com.aue.config.LifecycleConfig;
import com.aue.config.LifecycleConfigJSR250;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;

public class LifecycleTest {
    @Test
    @DisplayName("基础的利用注解指定init和destroy方法")
    public void annotationBasedInitAndDestroy() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);;
        System.setOut(printStream);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        ac.getBean("getLifecycleBean");
        Assertions.assertEquals("LifecycleBean.init" +
                System.lineSeparator(), out.toString());
        out.reset();
        ac.close();
        Assertions.assertEquals("LifecycleBean.destroy" +
                System.lineSeparator(), out.toString());
    }


    @Test
    @DisplayName("JSR250规范注解指定init和destroy方法")
    public void JSR250InitAndDestroy() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);;
        System.setOut(printStream);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfigJSR250.class);
        ac.getBean("getLifecycleBean");
        Assertions.assertEquals("LifecycleBeenJSR250.init" +
                System.lineSeparator(), out.toString());
        out.reset();
        ac.close();
        Assertions.assertEquals("LifecycleBeenJSR250.destroy" +
                System.lineSeparator(), out.toString());
    }
}
