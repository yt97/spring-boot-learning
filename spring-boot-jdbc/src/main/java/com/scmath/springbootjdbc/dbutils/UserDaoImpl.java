package com.scmath.springbootjdbc.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yt
 * @date 2020/3/15/015 18:02
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner runner = null;

    public UserDaoImpl(){
        runner = new QueryRunner();
    }



    /**
     *  执行修改 runner.update(conn, true, sql, params[]);
     *
     *  执行查询 runner.query(conn, false, sql, rsh, (Object[]) null);
     */
    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into t_user(userId,username,password)values(?,?,?)";
        return runner.update(DBUtils.getConnection(), sql, user.getUserId(),user.getUsername(),user.getPasswprd());
    }

    @Override
    public int deleteUser(int userId) throws SQLException {
        String sql = "delete from t_user where userId=?";
        return runner.update(DBUtils.getConnection(), sql, userId);
    }

    @Override
    public int updateUser(User user) throws SQLException {
        String sql = "update t_user set username=?,password=? where userId=?";
        return runner.update(DBUtils.getConnection(), sql, user.getUsername(),user.getPasswprd(),user.getUserId());
    }


    /**
     * 使用BeanHandler查询一个对象
     * 使用BeanListHandler查询所有对象
     */
    @Override
    public User selectUser(int userId) throws SQLException {
        String sql = "select username,password from t_user where userId=?";
        // List<User> users = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<>(User.class));
        return runner.query(DBUtils.getConnection(), sql, new BeanHandler<>(User.class),userId);
    }

    /**
     * 使用ScalarHandler查询一共有几条记录
     */
    @Override
    public long count()throws SQLException{
        String sql = "select count(userId) from t_user";
        return runner.query(DBUtils.getConnection(),sql, new ScalarHandler<>());
    }

}
