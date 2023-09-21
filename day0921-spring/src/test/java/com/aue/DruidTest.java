package com.aue;

import com.aue.config.DruidConfig;
import com.aue.druid.Druid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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



}
