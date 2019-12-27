package com.yifanyou.baeldung.java.concurrency.countdownlatch;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/27/2019 11:14 AM
 * 功能描述:
 * 修改历史:
 */
public class CountdownLatchCountExampleUnitTest {
    @Test
    public void whenCountDownLatch_completed() {
        CountdownLatchCountExample ex = new CountdownLatchCountExample(2);
        boolean isCompleted = ex.callTwiceInSameThread();
        assertTrue(isCompleted);
    }
}
