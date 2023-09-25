package com.aue.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwareConfig {
    @Bean
    public AwareBean getAwareBean() {
        return new AwareBean();
    }
}
