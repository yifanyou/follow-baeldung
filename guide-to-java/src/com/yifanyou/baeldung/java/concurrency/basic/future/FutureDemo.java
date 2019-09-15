package com.yifanyou.baeldung.java.concurrency.basic.future;

import java.util.concurrent.*;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:34 PM
 * 功能描述:
 * 修改历史:
 */
public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            // ...
            Thread.sleep(10000l);
            return "Hello world";
        });

        if (future.isDone() && !future.isCancelled()) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(future.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
