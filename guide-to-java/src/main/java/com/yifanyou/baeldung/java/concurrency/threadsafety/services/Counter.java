package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:06 PM
 * 功能描述:
 * 修改历史:
 */
public class Counter {
    private volatile int counter;

    public Counter() {
        this.counter = 0;
    }

    public synchronized void incrementCounter() {
        counter += 1;
    }

    public int getCounter() {
        return counter;
    }
}
