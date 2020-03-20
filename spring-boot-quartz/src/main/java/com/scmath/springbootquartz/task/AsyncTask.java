package com.scmath.springbootquartz.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 功能描述： 异步任务 业务类
 *
 * @author yt
 * @date 2020/3/20/020 15:38
 */
@Component
@Async
public class AsyncTask {

    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task1执行耗时" + (end-begin));
    }

    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("task2执行耗时" + (end-begin));
    }

    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("task3执行耗时" + (end-begin));
    }

    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task4执行耗时" + (end-begin));
        return new AsyncResult<>("task4");
    }

    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("task5执行耗时" + (end-begin));
        return new AsyncResult<>("task5");
    }

    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("task6执行耗时" + (end-begin));
        return new AsyncResult<>("task6");
    }


}
