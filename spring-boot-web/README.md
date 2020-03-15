##1.Mapping路径访问
   


##2.静态资源访问
 默认静态资源的访问路径 `ResourceProperties.class`：
   - /META-INF/resources/,
   - /resources/, 
   - /static/, 
   - /public/
   
 可通过 `spring.resources.staticLocations`配置属性修改。

##3. Servlet组件
 ### 3.1 传统web方式，（依赖Servlet3.0的注解）
 - 编写Servlet类并加 `@WebServlet`注解，
 - 需要启用 `@ServletComponentScan`扫描
 
 ### 3.2 注入IOC容器，（spring注解）
 - 编写Servlet类，不需要`@WebServlet`注解。
 - 装配`ServletRegistrationBean`装配到IOC容器
    
 
##4.Filter组件
 ### 4.1 传统web方式，（依赖Servlet3.0的注解）
  - 编写Filter类并加 `@WebFilter`注解，
  - 需要启用 `@ServletComponentScan`扫描
  
  ### 4.2 注入IOC容器
  - 编写Filter类，不需要`@WebFilter`注解。
  - 装配`FilterRegistrationBean`装配到IOC容器
 
##5.ServletContextListener组件
### 5.1 传统web方式，（依赖Servlet3.0的注解）
 - 编写Listener类并加 `@WebListener`注解，
 - 需要启用 `@ServletComponentScan`扫描
 
 ### 5.2 注入IOC容器
 - 编写Listener类，不需要`@WebListener`注解。
 - 装配`ServletListenerRegistrationBean`装配到IOC容器

##6. HandlerInterceptor拦截器
  在controller方法之前，可监控请求的信息。
1. 编写拦截器类并实现`HandlerInterceptor`接口。
2. `addInterceptor(InterceptorRegistry registry)`方法。 
   
##7. 异常处理
1. `ErrorMvcAutoConfiguration`类 默认的异常处理配置类。可exclude去掉
2. `ErrorPageRegistrar.registerErrorPages()`实现该方法，自定义错误页面。根据错误码或异常类型都可以
3. `@ExceptionHandler`注解。GlobalExceptionHandler配合`@ControllerAdvice`
 这种方式 多用于 处理不同的异常类型
 
##8. 定制优化Tomcat
###8.1 `ServerProperties`配置

###8.2 代码定制
关键类
