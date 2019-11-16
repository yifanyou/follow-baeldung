package com.yifanyou.baeldung.java.concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   youyifan
 * 创建时间: 11/17/2019 12:45 AM
 * 功能描述:
 * 修改历史:
 */
public class ExecutorServiceDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(10);

        ExecutorService executorService =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());

//        Runnable runnableTask = () -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

//        List<Callable<String>> callableTasks = new ArrayList<>();
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//
//        executorService.execute(runnableTask);
//        Future<String> future =
//                executorService.submit(callableTask);
//
//        String result = executorService.invokeAny(callableTasks);
//        List<Future<String>> futures = executorService.invokeAll(callableTasks);
//
//        executorService.shutdown();
//
//        List<Runnable> notExecutedTasks = executorService.shutdownNow();
//
//        executorService.shutdown();
//        try {
//            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
//                executorService.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            executorService.shutdownNow();
//        }

        Future<String> future = executorService.submit(callableTask);
//        String result = null;
//        try {
//            result = future.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        String result = future.get(200, TimeUnit.MILLISECONDS);

//        boolean canceled = future.cancel(true);
//        boolean isCancelled = future.isCancelled();


//        ScheduledExecutorService executorService = Executors
//                .newSingleThreadScheduledExecutor();
//
//        Future<String> resultFuture =
//                executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
//
//        Future<String> resultFuture = service
//                .scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);
//
//        service.scheduleWithFixedDelay(task, 100, 150, TimeUnit.MILLISECONDS);
    }
}
