package com.scmath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Administrator
 */
@SpringBootApplication
public class SpringBootStartApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(SpringBootStartApplication.class, args);
       // System.out.println(app.getBean("person"));
        System.out.println(app.getBean("cat"));
    }

}
