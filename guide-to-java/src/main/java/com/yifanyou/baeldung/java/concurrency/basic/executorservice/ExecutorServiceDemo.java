package com.yifanyou.baeldung.java.concurrency.basic.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:18 PM
 * 功能描述:
 * 修改历史:
 */
public class ExecutorServiceDemo {
    static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        executor.submit(new Task());

        //直接创建Runnable实例，所以没有打印信息；因为new Task()并没有执行run()方法
        executor.submit(() -> {
            new Task();
        });

        executor.shutdown();
        executor.shutdownNow();
        try {
            executor.awaitTermination(20l, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
