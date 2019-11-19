package com.yifanyou.baeldung.java.concurrency.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/19/2019 2:54 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadPoolInParallelStreamIntegrationTest {
    @Test
    public void giveRangeOfLongs_whenSummedInParallel_shouldBeEqualToExpectedTotal() throws InterruptedException, ExecutionException {
        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed().collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool
                .submit(() -> aList.parallelStream()
                        .reduce(0L, Long::sum))
                .get();

        assertEquals((lastNum + firstNum) * lastNum / 2, actualTotal);
    }

    @Test
    public void givenList_whenCallingParallelStream_shouldBeParallelStream() {
        List<Long> aList = new ArrayList<>();
        Stream<Long> parallelStream = aList.parallelStream();

        assertTrue(parallelStream.isParallel());
    }
}
