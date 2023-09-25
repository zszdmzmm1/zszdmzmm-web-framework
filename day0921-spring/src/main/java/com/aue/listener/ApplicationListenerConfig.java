package com.aue.listener;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.aue.listener")
public class ApplicationListenerConfig {
    @Bean
    public MyApplicationListener myApplicationListener() {
        return new MyApplicationListener();
    }
}
