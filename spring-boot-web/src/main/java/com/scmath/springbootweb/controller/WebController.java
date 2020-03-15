package com.scmath.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yt
 * @date 2019/8/3/003 18:56
 */
@RestController
@RequestMapping("/web")
public class WebController {

    @GetMapping("/demo1")
    public String demo1() {
        return "this is a simple Web Demo!";
    }

    @GetMapping("/error")
    public String error() {
        throw new IllegalArgumentException();
    }
}
