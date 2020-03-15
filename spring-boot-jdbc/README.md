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
