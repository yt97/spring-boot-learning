package com.scmath.springbootjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yt
 */
@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(JdbcApplication.class, args);

        //数据源类型：HikariDataSource
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getClass());

        //获取 数据库连接 connection
        Connection connection = dataSource.getConnection();
        //输出 HikariProxyConnection@1516759394 wrapping com.mysql.cj.jdbc.ConnectionImpl@545e57d7
        System.out.println(connection);
        connection.close();


        context.close();
    }

}
