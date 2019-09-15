package com.yifanyou.baeldung.java.concurrency.basic.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:37 PM
 * 功能描述:
 * 修改历史:
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // ...
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
