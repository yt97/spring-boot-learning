package com.scmath.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * @author Administrator
 *
 *  1.分析SpringBoot启动原理
 *  2.
 */
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {

        // 第一种启动方式 (先实例化SpringApplication，在调用run方法)
        SpringApplication app = new SpringApplication(StartApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        // 第二种启动方式 (直接调用静态的run方法，其内部实现同①)
        //ApplicationContext context = SpringApplication.run(StartApplication.class, args);

        System.out.println(context.getBean("cat"));

        // Tips： ClassUtils工具类，判断是否存在InputStream类
        boolean present = ClassUtils.isPresent("java.io.InputStream", null);
        System.out.println(present);

        context.close();
    }

}
