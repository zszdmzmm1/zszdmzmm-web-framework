package com.aue.config;

import org.springframework.context.annotation.Bean;

public class LifecycleConfigJSR250 {
    @Bean
    public LifecycleBeenJSR250 getLifecycleBean(){
        return new LifecycleBeenJSR250();
    }
}
