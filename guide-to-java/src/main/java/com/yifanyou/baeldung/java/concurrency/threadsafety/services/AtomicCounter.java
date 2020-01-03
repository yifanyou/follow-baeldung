package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:06 PM
 * 功能描述:
 * 修改历史:
 */
public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger();

    public AtomicCounter() {}

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public synchronized int getCounter() {
        return counter.get();
    }
}
