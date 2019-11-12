package com.yifanyou.baeldung.java.concurrency.threadpool;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 10/29/2019 10:22 AM
 * 功能描述:
 * 修改历史:
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //1 simple executor
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> System.out.print("Hello world"));

        //2 simple executorService
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        Future<String> future = executorService.submit(() -> "Hello World");
        // some operations
//        try {
//            String result = future.get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //3 FixedThreadPool shows pool size and current tasks size in queue
//        ThreadPoolExecutor executor =
//                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        System.out.println(executor.getPoolSize());
//        System.out.println(executor.getQueue().size());

        //4 CachedThreadPool show pool size and current tasks size in queue
//        ThreadPoolExecutor executor =
//                (ThreadPoolExecutor) Executors.newCachedThreadPool();
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        executor.submit(() -> {
//            Thread.sleep(1000);
//            return null;
//        });
//        System.out.println(executor.getPoolSize());
//        System.out.println(executor.getQueue().size());

        //5 single thread executor is ideal for creating an event loop; execute sequentially
//        AtomicInteger counter = new AtomicInteger();
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            counter.set(1);
//        });
//        executor.submit(() -> {
//            boolean eq = counter.compareAndSet(1, 2);
//            System.out.println(eq);
//        });
//        System.out.println(counter);

        //6 ScheduledThreadPool schedule method
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
//        executor.schedule(() -> {
//            System.out.println("Hello World");
//        }, 2000, TimeUnit.MILLISECONDS);

        //7 ScheduledThreadPool scheduleAtFixedRate method
//        CountDownLatch lock = new CountDownLatch(3);
//
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
//        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
//            System.out.println("Hello World");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.countDown();
//        }, 2000, 1000, TimeUnit.MILLISECONDS);
//
//        try {
//            lock.await(5000, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        future.cancel(true);

        //8 ForkJoinPool RecursiveTask
//        TreeNode tree = new TreeNode(5,
//                new TreeNode(3), new TreeNode(2,
//                new TreeNode(2), new TreeNode(8)));
//
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        int sum = forkJoinPool.invoke(new CountingTask(tree));
//        System.out.println(sum);

        //9 Guava directExecutor
//        Executor executor = MoreExecutors.directExecutor();
//        AtomicBoolean executed = new AtomicBoolean();
//        executor.execute(() -> {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            executed.set(true);
//        });
//        System.out.println(executed.get());

        //10 Guava getExitingExecutorService
//        ThreadPoolExecutor executor =
//                (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
//        ExecutorService executorService =
//                MoreExecutors.getExitingExecutorService(executor,
//                        100, TimeUnit.MILLISECONDS);
//
//        executorService.submit(() -> {
//            while (true) {
//            }
//        });

        //11 Guava Listening Decorators
        ExecutorService executorService = Executors.newCachedThreadPool();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<String> future1 =
                listeningExecutorService.submit(() -> "Hello");
        ListenableFuture<String> future2 =
                listeningExecutorService.submit(() -> "World");

        String greeting = null;
        try {
            greeting = Futures.allAsList(future1, future2).get() //Futures.allAsList(future1, future2).addListener()
                    .stream()
                    .collect(Collectors.joining(" "));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World " + greeting);
    }


    static class TreeNode {
        int value;

        Set<TreeNode> children;

        TreeNode(int value, TreeNode... children) {
            this.value = value;
            this.children = Sets.newHashSet(children);
        }
    }

    public static class CountingTask extends RecursiveTask<Integer> {

        private final TreeNode node;

        public CountingTask(TreeNode node) {
            this.node = node;
        }

        @Override
        protected Integer compute() {
            return node.value + node.children.stream()
                    .map(childNode -> new CountingTask(childNode).fork())
                    .collect(Collectors.summingInt(ForkJoinTask::join));
        }
    }
}
