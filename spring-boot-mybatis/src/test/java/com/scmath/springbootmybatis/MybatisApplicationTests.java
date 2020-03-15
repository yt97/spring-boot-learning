package com.scmath.springbootmybatis;

import com.scmath.springbootmybatis.entity.User;
import com.scmath.springbootmybatis.mapper.UserMapper;
import com.scmath.springbootmybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(MybatisApplicationTests.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() {
        final int row1 = userService.insert(new User("u1", "p1"));
        log.info("[添加结果] - [{}]", row1);
        final int row2 = userService.insert(new User("u2", "p2"));
        log.info("[添加结果] - [{}]", row2);
        final int row3 = userService.insert(new User("u1", "p3"));
        log.info("[添加结果] - [{}]", row3);
        final List<User> u1 = userService.findByUsername("u1");
        log.info("[根据用户名查询] - [{}]", u1);

    }

    @Test
    public void test02() {

        final long USER_NUM = 2000;

        ArrayList<User> list = new ArrayList<>();
        for(int i=0;i<USER_NUM;i++) {
            User user = new User("user"+i,"pass"+i);
            list.add(user);
        }

        long start = System.currentTimeMillis();
        for (User u:list) {
            userService.insert(u);
        }
        long end = System.currentTimeMillis();

        System.out.println("插入" + USER_NUM + "条用时[s]：" + (end-start)/1000);

    }
     /*  插入2000条用时[s]：107  */

    @Test
    public void test03() {

        long start = System.currentTimeMillis();
        List<User> u100 = userService.findByUsername("user1999");
        long end = System.currentTimeMillis();
        System.out.println(u100);
        System.out.println("查询 user1999 用时[ms]：" + (end-start));
    }
    //      查询 user1 用时[ms]：360
    //      查询 user100 用时[ms]：555
    //      查询 user1990 用时[ms]：525
    //      查询 user2500 用时[ms]：500
    //添加redis
    //      查询 user1990 用时[ms]：2826
    //      查询 li 用时[ms]：6258
    //      查询 li 用时[ms]：1551
    @Test
    public void test04() {
        stringRedisTemplate.opsForValue().set("coco","park");
        System.out.println(stringRedisTemplate.opsForValue().get("coco"));
        System.out.println(redisTemplate.opsForValue().get("li"));
        System.out.println(stringRedisTemplate.opsForValue().get("li"));

    }

    @Test
    public void test05() {
        User user = new User("li","lisi");
        userService.insert(user);
        redisTemplate.opsForValue().set("li",user);
        Object li = redisTemplate.opsForValue().get("li");
        System.out.println(user);
        System.out.println(li);
        long start = System.currentTimeMillis();
        List<User> list = userService.findByUsername("li");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
