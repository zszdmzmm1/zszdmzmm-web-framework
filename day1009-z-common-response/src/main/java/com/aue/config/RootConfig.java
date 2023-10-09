package com.aue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({DataSourceConfig.class, MybatisConfig.class})
@ComponentScan("com.aue.service")
@PropertySource("classpath:db.properties")
public class RootConfig {
}
