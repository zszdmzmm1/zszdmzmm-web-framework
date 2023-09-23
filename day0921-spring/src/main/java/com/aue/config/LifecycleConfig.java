package com.aue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifecycleBean getLifecycleBean(){
        return new LifecycleBean();
    }
}
