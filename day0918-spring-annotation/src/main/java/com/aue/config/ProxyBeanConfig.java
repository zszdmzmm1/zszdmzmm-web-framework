package com.aue.config;

import com.aue.pojo.Person;
import com.aue.service.UserService;
import com.aue.service.impl.NopeUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyBeanConfig {
    @Bean
    public Person getPerson() {
        return new Person();
    }

    @Bean(name = "userService")
    public UserService getUserService() {
        return new NopeUserService();
    }


}
