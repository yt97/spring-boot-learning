# A. SpringBoot运行流程
   1. 判断是否web环境
   2. 加载所有classpath下`META/spring.factories`里的 `ApplicatioinContextInitializer`
   3. 加载所有classpath下`META/spring.factories`里的 `ApplicatioinListener`
   4. 推断出main方法所在的类
   5. 开始执行`run()`方法
   6. 设置`java.awt.headless`系统变量
   7. 加载所有classpath下`META/spring.factories`里的 `SpringBootApplicatioinRunListener`
   8. 执行所有`SpringBootApplicatioinRunListener`的`started`方法
   9. 实例化`ApplicationArguments`对象
   10. 创建`environment`
   11. 配置`environment`，主要是把run方法的参数配置到`environment`
   12. 执行所有`SpringBootApplicatioinRunListener`的`environmentPrepared`方法
   13. 如果不是web环境，却配置了web的`environment`，则强制转换成标准的`environment`
   14. 打印`banner`
   15. 初始化`applicationContext`
   16. 如果`beanNameGennerator`不为空，就注入到`context`中
   17. 回调所有的`ApplicationContextInitlizer`方法
   18. 执行所有的`SpringBootApplicatioinRunListener`的`contextPrepared`方法
   19. 依次往spring容器中注入：`ApplicationArguments`，`Banner`
   20. 加载所有的源到`context`中
   21. 执行所有的`SpringBootApplicatioinRunListener`的`contextLoaded`方法
   22. 执行context的`refresh`方法，并且调用`context`的`registerShutdownHook`方法
   23. 回调，获取容器中所有的ApplicationRunner，CommandLineRunner接口，然后排序，调用
   24. 执行所有的`SpringBootApplicatioinRunListener`的`finished`方法
   25. 
   26. 
   27.
   
# B. 问题
   1. `primarySources` 和 `sources`区别？
   
   2. `initializers` 和 `listeners`
   
   3. `ResourceLoader`类的生命周期
   
   4. 
   
   5. 
   
   6. 
   
   7. 
   
   8. 
   
   9. 
   
   10. 
   
   11. 
   
   12. 
   
   13. 
   
   14. 
   
   15. 
   
   

# C. 实用Tips
   1. `org.springframework.util.ClassUtils`
   
   2. `Assert` 和 `Arrays.asList`的使用
        ```
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
   
   3. `StopWatch.class` : 
        not thread-safe. 
        Conceals use of System.currentTimeMillis().
   4. 
    getSpringFactoriesInstances(ApplicationContextInitializer.class));
    getSpringFactoriesInstances(ApplicationListener.class));
    getSpringFactoriesInstances(SpringApplicationRunListener.class, types, this, args));
    
   5. 
   6. 
   7. 
   8. 
   9. 
   10. 
   