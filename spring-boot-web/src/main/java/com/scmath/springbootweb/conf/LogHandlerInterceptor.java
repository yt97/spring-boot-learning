package com.scmath.springbootweb.conf;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yt
 * @date 2020/3/15/015 21:14
 *
 * controller方法拦截，可进行链路监控
 *
 */
public class LogHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("=======preHandle======");

        //记录 请求参数，时间，ip等信息

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) {
        System.out.println("=======postHandle======");

        //记录 请求处理结果

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) {
        System.out.println("=======afterCompletion======");
    }





}
