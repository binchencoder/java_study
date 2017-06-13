package com.chenbin.study.java.concurrent;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenbin on 2017/6/13.
 */
public class ExecutorServiceTest {

    @Test
    public void simpleTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        executorService.shutdown();
    }
}
