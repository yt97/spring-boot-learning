package com.scmath.springbootweb.conf;

import com.scmath.springbootweb.web.MyFilter;
import com.scmath.springbootweb.web.MyListener;
import com.scmath.springbootweb.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


;import java.util.Arrays;
import java.util.Collections;

/**
 * @author yt
 * @date 2020/3/15/015 21:11
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {



    @Bean //添加servlet
    public ServletRegistrationBean addServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean<>(new MyServlet());
        servlet.addUrlMappings("/servlet/*");
        return servlet;
    }

    @Bean //添加Filter
    public FilterRegistrationBean addFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean<>(new MyFilter());
        filter.setUrlPatterns(Collections.singletonList("/filter/*"));
        return filter;
    }

    @Bean //添加Listener
    public ServletListenerRegistrationBean addServletListener() {
        ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean<>(new MyListener());
        return listener;
    }

    //添加Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((new LogHandlerInterceptor()));
    }

}
