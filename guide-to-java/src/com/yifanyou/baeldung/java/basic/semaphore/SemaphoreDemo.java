package com.yifanyou.baeldung.java.basic.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:40 PM
 * 功能描述:
 * 修改历史:
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Available permit : " + semaphore.availablePermits());
        System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());

        if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
            semaphore.acquire();
            System.out.println("executing thread ");
            semaphore.release();
        }

        System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());
    }
}
