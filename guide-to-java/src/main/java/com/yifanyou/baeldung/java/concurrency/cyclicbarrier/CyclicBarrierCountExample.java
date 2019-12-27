package com.yifanyou.baeldung.java.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/27/2019 11:12 AM
 * 功能描述:
 * 修改历史:
 */
public class CyclicBarrierCountExample {

    private int count;

    public CyclicBarrierCountExample(int count) {
        this.count = count;
    }

    public boolean callTwiceInSameThread() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        Thread t = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();
        return cyclicBarrier.isBroken();
    }

    public static void main(String[] args) {
        CyclicBarrierCountExample ex = new CyclicBarrierCountExample(7);
        System.out.println("Count : " + ex.callTwiceInSameThread());
    }
}
