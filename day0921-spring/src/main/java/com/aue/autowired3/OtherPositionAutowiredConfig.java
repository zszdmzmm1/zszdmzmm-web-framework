package com.aue.autowired3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aue.autowired3")
public class OtherPositionAutowiredConfig {
    @Bean
    public Boss getBoss(@Autowired Car car){
        return new Boss(car);
    }
}
