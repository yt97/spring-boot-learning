## 1. Mapping路径访问
   


## 2. 静态资源访问
 默认静态资源的访问路径 `ResourceProperties.class`：
   - /META-INF/resources/,
   - /resources/, 
   - /static/, 
   - /public/
   
 可通过 `spring.resources.staticLocations`配置属性修改。

## 3. Servlet组件
 ### 3.1 传统web方式，（依赖Servlet3.0的注解）
 - 编写Servlet类并加 `@WebServlet`注解，
 - 需要启用 `@ServletComponentScan`扫描
 
 ### 3.2 注入IOC容器，（spring注解）
 - 编写Servlet类，不需要`@WebServlet`注解。
 - 装配`ServletRegistrationBean`装配到IOC容器
    
 
## 4. Filter组件
 ### 4.1 传统web方式，（依赖Servlet3.0的注解）
  - 编写Filter类并加 `@WebFilter`注解，
  - 需要启用 `@ServletComponentScan`扫描
  
  ### 4.2 注入IOC容器
  - 编写Filter类，不需要`@WebFilter`注解。
  - 装配`FilterRegistrationBean`装配到IOC容器
 
## 5. ServletContextListener组件
### 5.1 传统web方式，（依赖Servlet3.0的注解）
 - 编写Listener类并加 `@WebListener`注解，
 - 需要启用 `@ServletComponentScan`扫描
 
 ### 5.2 注入IOC容器
 - 编写Listener类，不需要`@WebListener`注解。
 - 装配`ServletListenerRegistrationBean`装配到IOC容器

## 6. HandlerInterceptor拦截器
  在controller方法之前，可监控请求的信息。
1. 编写拦截器类并实现`HandlerInterceptor`接口。
2. `addInterceptor(InterceptorRegistry registry)`方法。 
   
## 7. 异常处理
1. `ErrorMvcAutoConfiguration`类 默认的异常处理配置类。可exclude去掉
2. `ErrorPageRegistrar.registerErrorPages()`实现该方法，自定义错误页面。根据错误码或异常类型都可以
3. `@ExceptionHandler`注解。GlobalExceptionHandler配合`@ControllerAdvice`
 这种方式 多用于 处理不同的异常类型
 
## 8. 定制优化Tomcat
### 8.1 `ServerProperties`配置

### 8.2 代码定制

关键类


## 9. 日志
默认日志框架 ：logback

  三大模块：
   * logback-core
   * logback-classic
   * logback-access
   
Logback核心对象：

  * Logger：日志记录器
  * Appender：指定日志输出的目的地，控制台或文件
  * Layout：日志布局，格式化日志信息的输出
  
日志级别： Trace < Debug < Info < Warn < Error

日志示例：
    
    ===========log4j 设置 ==================
    log4j.rootLogger = debug,stdout,D,E
    
    ======== 输出到控制台 ===============
    log4j.appender.stdout = org.apache.log4j.ConsoleAppender
    log4j.appender.stdout.Target = System.out
    log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
    log4j.appender.stdout.layout.ConversionPattern =
            [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n
        
    ==== 输出Debug级别的日志到 D://logs/debug.log ===============
    log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
    log4j.appender.D.File = D://logs/debug.log
    log4j.appender.D.Appender = true
    log4j.appender.D.Threshold = DEBUG
    log4j.appender.D.layout = org.apache.log4j.PatternLayout
    log4j.appender.D.layout.ConversionPattern =
            %-d{yyyy-MM-dd HH:mm:ss} [%t:%r]-[%p] %m%n
     
    ==== 输出Error级别的日志到 D://logs/error.log ===============
    log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
    log4j.appender.E.File = D://logs/error.log
    log4j.appender.E.Appender = true
    log4j.appender.E.Threshold = ERROR
    log4j.appender.E.layout = org.apache.log4j.PatternLayout
    log4j.appender.E.layout.ConversionPattern =
            %-d{yyyy-MM-dd HH:mm:ss} [%t:%r]-[%p] %m%n
                      
    
    
    