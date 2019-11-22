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
public class SynchronizedHashMapWithRWLockManualTest {
    @Test
    public void whenWriting_ThenNoReading() {
        SynchronizedHashMapWithRWLock object = new SynchronizedHashMapWithRWLock();
        final int threadCount = 3;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        executeWriterThreads(object, threadCount, service);

        assertEquals(object.isReadLockAvailable(), false);

        service.shutdown();
    }

    @Test
    public void whenReading_ThenMultipleReadingAllowed() {
        SynchronizedHashMapWithRWLock object = new SynchronizedHashMapWithRWLock();
        final int threadCount = 5;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        executeReaderThreads(object, threadCount, service);

        assertEquals(object.isReadLockAvailable(), true);

        service.shutdown();
    }

    private void executeWriterThreads(SynchronizedHashMapWithRWLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++) {
            service.execute(() -> {
                try {
                    object.put("key" + threadCount, "value" + threadCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void executeReaderThreads(SynchronizedHashMapWithRWLock object, int threadCount, ExecutorService service) {
        for (int i = 0; i < threadCount; i++)
            service.execute(() -> object.get("key" + threadCount));
    }

}
