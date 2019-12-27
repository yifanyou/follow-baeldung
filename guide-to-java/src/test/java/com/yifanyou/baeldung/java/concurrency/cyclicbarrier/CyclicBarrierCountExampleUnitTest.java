package com.yifanyou.baeldung.java.concurrency.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/27/2019 11:15 AM
 * 功能描述:
 * 修改历史:
 */
public class CyclicBarrierCountExampleUnitTest {
    @Test
    public void whenCyclicBarrier_notCompleted() {
        CyclicBarrierCountExample ex = new CyclicBarrierCountExample(2);
        boolean isCompleted = ex.callTwiceInSameThread();
        assertFalse(isCompleted);
    }
}
