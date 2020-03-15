package com.scmath.springbootweb.web;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author yt
 * @date 2020/3/15/015 22:08
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==> MyFilter init====");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("==> MyFilter====" + servletRequest.getLocalAddr());
    }

    @Override
    public void destroy() {
        System.out.println("==> MyFilter destroy====");
    }
}
