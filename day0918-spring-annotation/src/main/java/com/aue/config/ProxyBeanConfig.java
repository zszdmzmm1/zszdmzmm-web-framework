package com.aue.config;

import com.aue.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyBeanConfig {
    @Bean
    public Person getPerson(){
        return new Person();
    }


}
