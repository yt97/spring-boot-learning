package com.scmath.springbootquartz.controller;

import com.scmath.springbootquartz.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author yt
 * @date 2020/3/20/020 15:45
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/async")
    public String asyncTask() throws InterruptedException {

        long begin = System.currentTimeMillis();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();

        while(true) {
            if(task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - begin));

        return "Async异步执行完毕";
    }


}
