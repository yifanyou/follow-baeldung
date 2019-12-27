package com.yifanyou.baeldung.java.concurrency.cyclicbarrier;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/27/2019 11:13 AM
 * 功能描述:
 * 修改历史:
 */
public class CyclicBarrierResetExample {

    private int count;
    private int threadCount;
    private final AtomicInteger updateCount;

    CyclicBarrierResetExample(int count, int threadCount) {
        updateCount = new AtomicInteger(0);
        this.count = count;
        this.threadCount = threadCount;
    }

    public int countWaits() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++)
            es.execute(() -> {
                try {
                    if (cyclicBarrier.getNumberWaiting() > 0) {
                        updateCount.incrementAndGet();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + cyclicBarrier.getNumberWaiting() + ": " + updateCount);
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return updateCount.get();
    }

    public static void main(String[] args) {
        CyclicBarrierResetExample ex = new CyclicBarrierResetExample(7, 20);
        System.out.println("Count : " + ex.countWaits());
    }
}
