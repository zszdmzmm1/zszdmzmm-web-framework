package com.aue.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {
    @Value("${spring_driverClassName}")
    private String driverClassName;
    @Value("${spring_url}")
    private String url;
    @Value("${spring_username}")
    private String userName;
    @Value("${spring_password}")
    private String password;

    @Bean
    public DataSource dataSource() {
       DruidDataSource dataSource = new DruidDataSource();
       dataSource.setUrl(url);
       dataSource.setDriverClassName(driverClassName);
       dataSource.setUsername(userName);
       dataSource.setPassword(password);
       return dataSource;
    }

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
