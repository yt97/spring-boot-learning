package com.scmath.springbootweb.conf;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yt
 * @date 2020/3/15/015 22:31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=NullPointerException.class)
    public String fun1(Exception e) {
        return e.getMessage();
    }

}
