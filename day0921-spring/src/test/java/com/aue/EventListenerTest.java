package com.aue;

import com.aue.listener.ApplicationListenerConfig;
import com.aue.listener.MyEvent;
import com.aue.listener.MyEventSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EventListenerTest {
    @Test
    @DisplayName("ApplicationListener, ApplicationEvent")
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);


        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationListenerConfig.class);
        MyEventSource myEventSource =(MyEventSource) ac.getBean("myEventSource");

        ac.publishEvent(new MyEvent(myEventSource));

        Assertions.assertEquals("用户名:hjf" + System.lineSeparator() +
                "密码:123456" + System.lineSeparator(), out.toString());
    }
}
