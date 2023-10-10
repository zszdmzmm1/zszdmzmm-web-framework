package com.aue.config;

import com.aue.controller.interceptor.MyInterceptor;
import com.aue.controller.interceptor.YInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.aue.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/demo/**").excludePathPatterns("/demo/interceptor");
        registry.addInterceptor(new YInterceptor()).addPathPatterns("/demo/**").excludePathPatterns("/demo/interceptor");
    }
}
