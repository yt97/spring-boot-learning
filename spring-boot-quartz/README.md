#  1. java.util.Timer类
    配置比较麻烦，时间延后等问题
    
#  2. Quartz框架
    配置简单，封装性高。
    
#  3. schedule
    整合性高，springboot默认自带。
    
## 3.1 使用方法
   1. `@EnableScheduling`注解,开启定时任务
   2. `@Component,@Scheduled(..)`,定时执行方法
   
    @Scheduled(fixedRate=2000)  //2秒执行一次
    @Scheduled(fixedDelay=2000)  //结束后，延迟2秒执行
    @Scheduled(fixedRateString="2000")  //字符串形式
    @Scheduled(fixedDelayString="2000") //配置文件指定
    @Scheduled(cron="*/1 * * * * *")  //每秒执行一次
    
## 3.2 线程池
？？？？？？？？？？？？？？？？？？？？？？？？？？？？？


# 4. 异步任务
   1. `@EnableAsync`注解,开启定时任务
   2. `@Component,@Async`,异步执行方法
   3. 去掉`@Async`，则是同步方法。
   
    返回类型Future<String>,返回结果AsyncResult<String>("");
    通过task.isDone()判断异步方法 是否执行结束 
    
