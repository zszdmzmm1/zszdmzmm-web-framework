package com.aue.config;

import com.aue.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeAndLazyConfig {
    @Bean
    @Scope("prototype")
    public Person getPerson(){
        return new Person();
    }

    @Bean
    //@Scope("singleton")
    public Person getPerson1(){
        return new Person();
    }

}
