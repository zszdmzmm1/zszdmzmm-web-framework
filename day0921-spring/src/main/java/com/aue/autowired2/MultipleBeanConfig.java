package com.aue.autowired2;

import com.aue.autowired2.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aue.autowired2.bean")
public class MultipleBeanConfig {
    @Bean
    public MyBean myBean(){
        return new MyBean("other");
    }
}
