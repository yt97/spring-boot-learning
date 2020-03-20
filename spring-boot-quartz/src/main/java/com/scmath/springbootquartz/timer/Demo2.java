package com.scmath.springbootquartz.timer;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yt
 * @version 1.0
 * @date 2020/1/14/014 21:13
 */
public class Demo2 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "定时任务：执行。。。[" +
                        new Date(System.currentTimeMillis()) + "]");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);
    }
}
