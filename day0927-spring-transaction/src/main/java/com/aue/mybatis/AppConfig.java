package com.aue.mybatis;

import com.aue.mybatis.config.DataSourceConfig;
import com.aue.mybatis.config.MybatisConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
@Import({DataSourceConfig.class, MybatisConfig.class})
public class AppConfig {
}
