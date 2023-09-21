package com.aue;

import com.aue.config.DruidConfig;
import com.aue.druid.Druid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DruidTest {
    @Test
    public void connectionTest() throws SQLException {
        DataSource dataSource = Druid.dataSource;
        Connection connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
    }


    @Test
    @DisplayName("Spring Druid 不好的写法")
    public void connectionTest1() throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DruidConfig.class);
        DataSource dataSource = (DataSource) ac.getBean("getDataSource");
        Connection connection = dataSource.getConnection();
        Connection connection1 = dataSource.getConnection();
        Assertions.assertNotNull(connection);
        Assertions.assertNotSame(connection1, connection);
    }

    @Test
    @DisplayName("Spring Druid DI Setter注入")
    public void connectionTest2() throws SQLException {
        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("druid.xml");
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        Connection connection1 = dataSource.getConnection();
        Assertions.assertNotNull(connection);
        Assertions.assertNotSame(connection1, connection);
    }

}
