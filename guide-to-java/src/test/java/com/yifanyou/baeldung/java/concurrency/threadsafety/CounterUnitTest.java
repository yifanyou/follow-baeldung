package com.yifanyou.baeldung.java.concurrency.threadsafety;

import com.yifanyou.baeldung.java.concurrency.threadsafety.callables.CounterCallable;
import com.yifanyou.baeldung.java.concurrency.threadsafety.services.Counter;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:00 PM
 * 功能描述:
 * 修改历史:
 */
public class CounterUnitTest {
    @Test
    public void whenCalledIncrementCounter_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Counter counter = new Counter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new CounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        assertThat(counter.getCounter()).isEqualTo(2);
    }
}
