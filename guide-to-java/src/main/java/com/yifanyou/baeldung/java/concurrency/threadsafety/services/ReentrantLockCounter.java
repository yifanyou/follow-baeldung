package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:07 PM
 * 功能描述:
 * 修改历史:
 */
public class ReentrantLockCounter {
    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);

    public ReentrantLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}
