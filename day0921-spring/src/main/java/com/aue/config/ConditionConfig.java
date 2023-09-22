package com.aue.config;

import com.aue.pojo.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowCondition.class)
    public Environment getWindowEnvironment(){
        return new Environment("Windows");
    }

    @Bean
    @Conditional(MacCondition.class)
    public Environment getMacEnvironment(){
        return new Environment("Mac");
    }
}
