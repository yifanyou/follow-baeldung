package com.yifanyou.baeldung.java.concurrency.basic.scheduledexecutorservice;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:25 PM
 * 功能描述:
 * 修改历史:
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
        demo.execute();
        demo.executeWithMultiThread();
    }

    private void execute() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private void executeWithMultiThread() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksToRun() {
        return (executorService -> {
            ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
                // Task
                System.out.println("ScheduledExecutorService delay 1s");
            }, 1, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(() -> {
                // Task
                System.out.println("ScheduledExecutorService initialDelay 1s period 10s");
            }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture3 = executorService.scheduleWithFixedDelay(() -> {
                // Task
                System.out.println("ScheduledExecutorService initialDelay 1s delay 10s");
            }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<String> scheduledFuture4 = executorService.schedule(() -> {
                // Task
                System.out.println("ScheduledExecutorService delay 1");
                return "Hellow world";
            }, 1, TimeUnit.SECONDS);
            return null;
        });
    }

}
