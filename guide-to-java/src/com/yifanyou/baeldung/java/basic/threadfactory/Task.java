package com.yifanyou.baeldung.java.basic.threadfactory;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:11 PM
 * 功能描述:
 * 修改历史:
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("hello thread factory");
    }
}
