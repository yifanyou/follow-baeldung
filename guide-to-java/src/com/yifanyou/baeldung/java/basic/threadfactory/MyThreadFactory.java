package com.yifanyou.baeldung.java.basic.threadfactory;

import java.util.concurrent.ThreadFactory;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:51 PM
 * 功能描述:
 * 修改历史:
 */
public class MyThreadFactory implements ThreadFactory {
    private int threadId;
    private String name;

    public MyThreadFactory(String name) {
        threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + threadId);
        System.out.println("created new thread with id : " + threadId +
                " and name : " + t.getName());
        threadId++;
        return t;
    }
}
