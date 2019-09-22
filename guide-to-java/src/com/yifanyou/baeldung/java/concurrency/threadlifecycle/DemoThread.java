package com.yifanyou.baeldung.java.concurrency.threadlifecycle;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/22/2019 10:53 PM
 * 功能描述:
 * 修改历史:
 */
public class DemoThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted");
        }
    }
}
