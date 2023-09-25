package com.aue.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Profile({"test", "dev"})
    @Bean
    public BeanOne getBeanOne() {
        return new BeanOne();
    }


    @Profile("test")
    @Bean
    public BeanTwo getBeanTwo() {
        return new BeanTwo();
    }


    @Profile("prod")
    @Bean
    public BeanThree getBeanThree() {
        return new BeanThree();
    }
}
