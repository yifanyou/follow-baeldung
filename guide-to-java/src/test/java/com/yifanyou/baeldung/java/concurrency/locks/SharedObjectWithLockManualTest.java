package com.yifanyou.baeldung.java.concurrency.locks;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/22/2019 1:43 PM
 * 功能描述:
 * 修改历史:
 */
public class SharedObjectWithLockManualTest {
    @Test
    public void whenLockAcquired_ThenLockedIsTrue() {
        final SharedObjectWithLock object = new SharedObjectWithLock();

        final int threadCount = 2;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        executeThreads(object, threadCount, service);

        assertEquals(true, object.isLocked());

        service.shutdown();
    }

    @Test
    public void whenLocked_ThenQueuedThread() {
        final int threadCount = 4;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final SharedObjectWithLock object = new SharedObjectWithLock();

        executeThreads(object, threadCount, service);

        assertEquals(object.hasQueuedThreads(), true);

        service.shutdown();

    }

    public void whenTryLock_ThenQueuedThread() {
        final SharedObjectWithLock object = new SharedObjectWithLock();

        final int threadCount = 2;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        executeThreads(object, threadCount, service);

        assertEquals(true, object.isLocked());

        service.shutdown();
    }

    @Test
    public void whenGetCount_ThenCorrectCount() throws InterruptedException {
        final int threadCount = 4;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final SharedObjectWithLock object = new SharedObjectWithLock();

        executeThreads(object, threadCount, service);
        Thread.sleep(1000);
        assertEquals(object.getCounter(), 4);

        service.shutdown();

    }

    private void executeThreads(SharedObjectWithLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++) {
            service.execute(object::perform);
        }
    }
}
