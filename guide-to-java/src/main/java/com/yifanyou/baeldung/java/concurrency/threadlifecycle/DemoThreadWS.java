package com.yifanyou.baeldung.java.concurrency.threadlifecycle;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/22/2019 10:50 PM
 * 功能描述:
 * 修改历史:
 */
public class DemoThreadWS implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }

        System.out.println(WaitingState.t1.getState());
    }
}
