package com.scmath.springbootquartz.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author yt
 * @date 2020/3/20/020 16:22
 * 功能描述： 定时任务 业务类
 */
@Component
public class ScheduleTask {

    @Scheduled(fixedRate=5000)
    public void task1() {
        System.out.println("task1-当前时间：" + LocalDateTime.now());
        System.out.println("====" + Thread.currentThread() + "==========");
    }

    @Scheduled(fixedDelay=3000)
    public void task2() throws InterruptedException {
        System.out.println("task2-当前时间：" + LocalDateTime.now());
        Thread.sleep(4000);
        System.out.println("====" + Thread.currentThread() + "==========");
    }

    @Scheduled(cron="*/1 * * * * *")
    public void task3() throws InterruptedException {
        System.out.println("task3-当前时间：" + LocalDateTime.now());
        Thread.sleep(4000);
        System.out.println("====" + Thread.currentThread() + "==========");
    }

    @Scheduled(fixedRateString="${time.fixedDelay}")
    public void task4() {
        System.out.println("task4-当前时间：" + LocalDateTime.now());
        System.out.println("====" + Thread.currentThread() + "==========");
    }
}
