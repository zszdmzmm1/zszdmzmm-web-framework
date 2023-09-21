package com.aue.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.aue.druid.Druid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class DruidConfig{

    @Bean
    public DataSource getDataSource(){
        Properties prop = new Properties();
        try (InputStream inputStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties")){
            prop.load(inputStream);
            return DruidDataSourceFactory.createDataSource(prop);
            //从池子中获得连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
