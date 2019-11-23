package com.yifanyou.baeldung.java.concurrency.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/23/2019 11:35 PM
 * 功能描述:
 * 修改历史:
 */
public class DelayedCallable implements Callable<String> {

    private String name;
    private long period;
    private CountDownLatch latch;

    public DelayedCallable(String name, long period, CountDownLatch latch) {
        this(name, period);
        this.latch = latch;
    }

    public DelayedCallable(String name, long period) {
        this.name = name;
        this.period = period;
    }

    public String call() {

        try {
            Thread.sleep(period);

            if (latch != null) {
                latch.countDown();
            }

        } catch (InterruptedException ex) {
            // handle exception
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }

        return name;
    }
}
