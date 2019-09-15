package com.yifanyou.baeldung.java.basic.threadfactory;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:50 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadFactoryDemo {
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory(
                "MyThreadFactory");
        for (int i = 0; i < 10; i++) {
            Thread t = factory.newThread(new Task());
            t.start();
        }
    }
}
