package com.yifanyou.baeldung.java.concurrency.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/21/2019 10:46 AM
 * 功能描述:
 * 修改历史:
 */
public class WaitingWorker implements Runnable {
    private final List<String> outputScraper;
    private final CountDownLatch readyThreadCounter;
    private final CountDownLatch callingThreadBlocker;
    private final CountDownLatch completedThreadCounter;

    WaitingWorker(final List<String> outputScraper, final CountDownLatch readyThreadCounter, final CountDownLatch callingThreadBlocker, CountDownLatch completedThreadCounter) {

        this.outputScraper = outputScraper;
        this.readyThreadCounter = readyThreadCounter;
        this.callingThreadBlocker = callingThreadBlocker;
        this.completedThreadCounter = completedThreadCounter;
    }

    @Override
    public void run() {
        // Mark this thread as read / started
        readyThreadCounter.countDown();
        try {
            callingThreadBlocker.await();
            outputScraper.add("Counted down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            completedThreadCounter.countDown();
        }
    }
}
