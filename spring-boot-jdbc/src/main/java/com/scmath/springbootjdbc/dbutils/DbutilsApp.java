package com.scmath.springbootjdbc.dbutils;

import java.sql.SQLException;

/**
 * @author yt
 * @date 2020/3/15/015 17:32
 */
public class DbutilsApp {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();

        long count = userDao.count();
        System.out.println("总记录数：" + count);
    }
}
