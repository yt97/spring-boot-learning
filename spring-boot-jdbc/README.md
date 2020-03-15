# 1. JDBC原生api操作


# 2. `Dbutils`轻量工具
   `DBUtils`是apache下的一个小巧的JDBC轻量级封装的工具包，其最核心的特性是结果集的封装，可以直接将查询出来的结果集封装成`POJO`
   ``` 
   <dependency>
          <groupId>commons-dbutils</groupId>
          <artifactId>commons-dbutils</artifactId>
          <version>1.7</version>
       </dependency>
   ````
   DbUtils中的核心的类是`QueryRunner`类。封装了CURD操作。
   
   A. 执行修改 `runner.update(conn, true, sql, params[]);`
   
   B. 执行查询 `runner.query(conn, false, sql, rsh, (Object[]) null);`
   
# 3. `JDBCTemplete`工具类
   Spring封装，直接@Autowire注入
   `jdbcTemplete.execute(sql);`
   
# 4. 事务
`@EnableTransactionManagement`启用事务支持。
然后在事务方法上加 `@Transactional`
* 默认只对RuntimeException回滚,非运行时异常不回滚
* 对`private`函数无效
* `@Transactional(rollbackFor=Exception.class)`制定策略
   `@Transactional(norollbackFor=Exception.class)`
