package com.aue.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class Druid {

    public static DataSource dataSource;


    static {
        Properties prop = new Properties();
        //Connection connection = null;
        try (InputStream inputStream = Druid.class.getClassLoader().getResourceAsStream("druid.properties")){
            prop.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
            //从池子中获得连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

