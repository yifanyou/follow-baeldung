package com.yifanyou.baeldung.java.concurrency.runnablecallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/12/2019 11:15 PM
 * 功能描述:
 * 修改历史:
 */
public class RunableCallableDemo {
    private static ExecutorService executorService;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executorService = Executors.newSingleThreadExecutor();
//        Future future = executorService.submit(new EventLoggingTask());

//        FactorialTask task = new FactorialTask(5);
//        Future<Integer> future = executorService.submit(task);
//        System.out.print(120 + " - " + future.get().intValue());

//        FactorialTaskWithExceptionHandle task = new FactorialTaskWithExceptionHandle(-5);
//        Future<Integer> future = executorService.submit(task);
//        Integer result = future.get().intValue();

        FactorialTaskWithExceptionHandle task = new FactorialTaskWithExceptionHandle(-5);
        Future<Integer> future = executorService.submit(task);
        System.out.print(future.isDone());

        executorService.shutdown();
    }
}
