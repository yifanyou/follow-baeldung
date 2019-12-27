package com.yifanyou.baeldung.java.concurrency.cyclicbarrier;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/27/2019 11:16 AM
 * 功能描述:
 * 修改历史:
 */
public class CyclicBarrierResetExampleUnitTest {
    @Test
    public void whenCyclicBarrier_reset() {
        CyclicBarrierResetExample ex = new CyclicBarrierResetExample(7,20);
        int lineCount = ex.countWaits();
        // lineCount 变化的原因是每个线程调用 cyclicBarrier.getNumberWaiting() 时同时获得 0 的线程数在变化
        System.out.println(lineCount);
        assertTrue(lineCount > 7);
    }
}
