package com.yifanyou.baeldung.java.concurrency.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/21/2019 10:45 AM
 * 功能描述:
 * 修改历史:
 */
public class Worker implements Runnable {
    private final List<String> outputScraper;
    private final CountDownLatch countDownLatch;

    Worker(final List<String> outputScraper, final CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // Do some work
        System.out.println("Doing some logic");
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }
}
