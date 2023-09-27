package com.aue.mybatis;

import com.aue.mybatis.config.DataSourceConfig;
import com.aue.mybatis.config.MybatisConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@Import({DataSourceConfig.class, MybatisConfig.class})
@ComponentScan("com.aue.mybatis.service")
@EnableTransactionManagement
public class AppConfig {
}
