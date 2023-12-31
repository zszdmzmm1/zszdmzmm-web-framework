package com.aue.autowired2;

import com.aue.autowired2.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ComponentScan("com.aue.autowired2.bean")
@Configuration
public class QualifierConfig {
    @Bean
    public MyBean myBean1(){
        return new MyBean("other");
    }

    @Bean
    @Primary
    public MyBean myBean2(){
        return new MyBean("another");
    }
}
