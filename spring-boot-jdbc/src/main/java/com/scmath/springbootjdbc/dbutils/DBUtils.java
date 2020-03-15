package com.scmath.springbootjdbc.dbutils;

import java.sql.*;

/**
 * @author yt
 * @date 2020/3/15/015 18:03
 * 自定义封装： 加载驱动，获取connection。
 */
public class DBUtils {
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static String DRIVER;

    static {
        USERNAME = "root";
        PASSWORD = "root";
        URL = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Hongkong";
        DRIVER = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DBUtils() {}

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        }
        return conn;
    }


}
