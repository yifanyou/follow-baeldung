package com.yifanyou.baeldung.java.concurrency.runnablecallable;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/12/2019 11:14 PM
 * 功能描述:
 * 修改历史:
 */
public class EventLoggingTask implements Runnable {
    @Override
    public void run() {
        System.out.print("Message");
    }
}
