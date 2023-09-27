package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan("com.aue")
@Configuration
@EnableAspectJAutoProxy
public class StartTimeAopConfig {
}
