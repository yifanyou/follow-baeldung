package com.yifanyou.baeldung.java.concurrency.threadsafety;

import com.yifanyou.baeldung.java.concurrency.threadsafety.callables.ReentranReadWriteLockCounterCallable;
import com.yifanyou.baeldung.java.concurrency.threadsafety.services.ReentrantReadWriteLockCounter;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:01 PM
 * 功能描述:
 * 修改历史:
 */
public class ReentrantReadWriteLockCounterUnitTest {
    @Test
    public void whenCalledIncrementCounter_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantReadWriteLockCounter counter = new ReentrantReadWriteLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        assertThat(counter.getCounter()).isEqualTo(2);
    }
}
