package com.aue.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBeenJSR250 {
    @PostConstruct
    public void init() {
        System.out.println("LifecycleBeenJSR250.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("LifecycleBeenJSR250.destroy");
    }
}
