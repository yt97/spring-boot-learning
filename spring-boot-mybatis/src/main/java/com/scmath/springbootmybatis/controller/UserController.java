package com.scmath.springbootmybatis.controller;

import com.scmath.springbootmybatis.entity.User;
import com.scmath.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yt
 * @date 2019/8/4/004 19:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int addUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @GetMapping("/del")
    public int delUser(int userId) {
        return userService.delete(userId);
    }

    @GetMapping("/list/all")
    public List<User> queryAll(){
        return userService.queryAll();
    }

}
