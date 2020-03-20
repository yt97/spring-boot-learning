package com.scmath.springbootquartz.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *          jdk类
 * @author yt
 * @version 1.0
 * @date 2020/1/14/014 20:08
 */
public class Demo1 {

    private static void timer1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "定时任务：每4秒执行[" +
                        new Date(System.currentTimeMillis()) + "]");
            }
        },3*1000,4*1000);
    }

    private static void timer2() {

        Calendar calendar = Calendar.getInstance();
        //设置时分秒
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 0);
        // 得出执行任务的时间,此处为今天的12：00：00
        Date time = calendar.getTime();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "-------设定要指定任务-" +
                        new Date(System.currentTimeMillis()) +
                        "-------");
            }
        }, time, 1000 * 60 * 60 * 24);
        // 这里设定将延时每天固定执行，周期为 一天 24*60*60s
    }

    public static void main(String[] args) {
        timer1();
        timer2();
    }
}
