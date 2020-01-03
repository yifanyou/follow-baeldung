package com.yifanyou.baeldung.java.concurrency.threadsafety.callables;

import com.yifanyou.baeldung.java.concurrency.threadsafety.services.ExtrinsicLockCounter;

import java.util.concurrent.Callable;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:12 PM
 * 功能描述:
 * 修改历史:
 */
public class ExtrinsicLockCounterCallable implements Callable<Integer> {
    private final ExtrinsicLockCounter counter;

    public ExtrinsicLockCounterCallable(ExtrinsicLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
