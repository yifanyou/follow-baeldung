package com.yifanyou.baeldung.java.concurrency.threadjoin;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/13/2019 10:46 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
//        Thread t2 = new SampleThread(1);
//        t2.start();
//        System.out.println("Invoking join");
//        t2.join();
//        System.out.println("Returned from join");
//        System.out.println(t2.isAlive());

        //timeout
        Thread t3 = new SampleThread(10);
        t3.start();
        t3.join(1000);
        System.out.println(t3.isAlive());
    }
}
