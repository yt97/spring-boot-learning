package com.scmath.springbootmybatis.service;

import com.scmath.springbootmybatis.entity.User;
import com.scmath.springbootmybatis.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yt
 * @date 2019/8/3/003 23:15
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int insert(User user){
        return userMapper.insert(user);
    }

    public int delete(Integer userId){
        return userMapper.deleteUser(userId);
    }

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    public List<User> findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    public List<User> findByUserId(String userId){
        return userMapper.findByUserId(userId);
    }

}
