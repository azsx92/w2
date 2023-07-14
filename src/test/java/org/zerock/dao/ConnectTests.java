package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    @Test
    public void testConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_db",
                "jdbc_db",
                "1234");

        Assertions.assertNotNull(connection);

        connection.close();
    }

    @Test
    public void test1() {

        int v1 = 10;
        int v2 = 110;

        Assertions.assertEquals(v1,v2);

    }

    @Test
    public void testHikariCP() throws Exception {

        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("org.mariadb.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
//        config.setJdbcUrl("jdbc:mariadb://localhost:3306/jdbc_db");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_db");
        config.setUsername("jdbc_db");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();

        System.out.println(connection);

        connection.close();

    }

}

