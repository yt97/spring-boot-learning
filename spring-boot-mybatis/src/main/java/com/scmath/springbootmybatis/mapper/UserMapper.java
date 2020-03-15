package com.scmath.springbootmybatis.mapper;

import com.scmath.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yt
 * @date 2019/8/3/003 23:01
 */
@Mapper
//@Service
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "userId")
    @Insert("insert into t_user(username,password) value(#{username},#{password})")
    int insert(User user);

    @Delete("delete from t_user where userId=#{userId}")
    int deleteUser(Integer userId);

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    List<User> findByUsername(@Param("username") String username);

    @Select("SELECT * FROM t_user WHERE userId = #{userId}")
    List<User> findByUserId(@Param("userId") String userId);

    @Select("select * from t_user")
    List<User> queryAll();
}
