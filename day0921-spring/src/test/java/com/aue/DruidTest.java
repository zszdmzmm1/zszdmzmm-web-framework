package com.aue;

import com.aue.druid.Druid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
