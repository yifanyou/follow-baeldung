package com.yifanyou.baeldung.java.concurrency.waitandsleep;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/18/2019 10:37 PM
 * 功能描述: ThreadA作为监督器
 * 修改历史:
 */
public class ThreadA {
    private static final ThreadB b = new ThreadB();

    /**
     * 当线程访问对象的同步代码块时，其他线程不能访问同步代码块
     * 现象：b线程先等待当前线程执行同步代码块，当前线程在同步代码块中执行wait操作后，b线程开始执行
     * @param args
     * @throws InterruptedException
     */
    public static void main(String... args) throws InterruptedException {
        b.start();
        synchronized (b) {
            while (b.sum == 0) {
                System.out.println("Waiting for ThreadB to complete...");
                b.wait();
            }
            System.out.println("ThreadB has completed. Sum from that thread is: " + b.sum);
        }
    }
}
