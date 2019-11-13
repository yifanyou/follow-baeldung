package com.yifanyou.baeldung.java.concurrency.threadjoin;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   youyifan
 * 创建时间: 11/13/2019 10:44 PM
 * 功能描述:
 * 修改历史:
 */
public class SampleThread extends Thread{
    public int processingCount = 0;

    SampleThread(int processingCount) {
        this.processingCount = processingCount;
        System.out.println("Thread Created");
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }
        System.out.println("Thread " + this.getName() + " exiting");
    }
}
