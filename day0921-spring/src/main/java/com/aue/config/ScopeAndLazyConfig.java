package com.aue.config;

import com.aue.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeAndLazyConfig {
    @Bean
    @Scope("prototype")
    public Person getPerson(){
        System.out.println("ScopeAndLazyConfig.getPerson");
        return new Person();
    }

    @Bean
    //@Scope("singleton")
    public Person getPerson1(){
        System.out.println("ScopeAndLazyConfig.getPerson1");
        return new Person();
    }

    @Bean
    //@Scope("singleton")
    @Lazy
    public Person getPerson2(){
        System.out.println("ScopeAndLazyConfig.getPerson2");
        return new Person();
    }
}
