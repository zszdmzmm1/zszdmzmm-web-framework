package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.aue.dao", "com.aue.service"})
public class MyRootConfig {
}
