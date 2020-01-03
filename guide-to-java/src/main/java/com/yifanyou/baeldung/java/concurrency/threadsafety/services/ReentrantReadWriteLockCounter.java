package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:08 PM
 * 功能描述:
 * 修改历史:
 */
public class ReentrantReadWriteLockCounter {
    private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public ReentrantReadWriteLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        writeLock.lock();
        try {
            counter += 1;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }
}
