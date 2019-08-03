package com.scmath.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author yt
 * @version 1.0
 * @date 2019/8/3/003 18:56
 * @Description TODO
 *
 * @RestController  等同于 （@Controller 与 @ResponseBody）
 */
@RestController
public class WebController {

    @GetMapping("/demo1")
    public String demo1() {
        System.out.println("WebController----->demo1()");
        return "Hello! Web";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        System.out.println("WebController里的bean----->commandLineRunner(ctx)");
        // 目的是
        return args -> {
            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }
}
