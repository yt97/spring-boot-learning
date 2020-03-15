package com.scmath.springbootjdbc.dbutils;

import java.sql.SQLException;

/**
 * @author yt
 * @date 2020/3/15/015 17:59
 */
interface UserDao {

    int addUser(User user) throws SQLException;

    int deleteUser(int id) throws SQLException;

    User selectUser(int userId) throws SQLException;

    int updateUser(User user) throws SQLException;

    long count()throws SQLException;
}
