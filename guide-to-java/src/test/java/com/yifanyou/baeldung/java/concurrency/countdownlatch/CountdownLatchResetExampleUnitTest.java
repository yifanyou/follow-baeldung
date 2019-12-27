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
public class CountdownLatchResetExampleUnitTest {
    @Test
    public void whenCountDownLatch_noReset() {
        CountdownLatchResetExample ex = new CountdownLatchResetExample(7,20);
        int lineCount = ex.countWaits();
        assertTrue(lineCount <= 7);
    }
}
