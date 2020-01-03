package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:06 PM
 * 功能描述:
 * 修改历史:
 */
public class ExtrinsicLockCounter {
    private int counter;
    private final Object lock = new Object();

    public ExtrinsicLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        synchronized (lock) {
            counter += 1;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }
}
