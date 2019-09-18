package com.yifanyou.baeldung.java.concurrency.waitandsleep;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/18/2019 10:37 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadB extends Thread {
    int sum;

    @Override
    public void run() {
        synchronized (this) {
            int i = 0;
            while (i < 100000) {
                sum += i;
                i++;
            }
            notify();
        }
    }

    public int getSum() {
        return sum;
    }
}
