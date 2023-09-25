package com.aue.autowired2;

import com.aue.autowired2.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.aue.autowired2.bean")
@Configuration
public class PrimaryConfig {
    @Bean
    public MyBean myBean1(){
        return new MyBean("other");
    }
}
