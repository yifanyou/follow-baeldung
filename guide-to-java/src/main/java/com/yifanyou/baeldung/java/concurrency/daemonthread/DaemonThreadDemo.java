package com.yifanyou.baeldung.java.concurrency.daemonthread;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   youyifan
 * 创建时间: 11/14/2019 11:27 PM
 * 功能描述:
 * 修改历史:
 */
public class DaemonThreadDemo {

    public static void main(String[] args) {
//        NewThread daemonThread = new NewThread();
//        daemonThread.setDaemon(true);
//        daemonThread.start();

//        NewThread daemonThread = new NewThread();
//        daemonThread.start();
//        daemonThread.setDaemon(true);

        NewThread daemonThread = new NewThread();
        NewThread userThread = new NewThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        userThread.start();

        System.out.println(daemonThread.isDaemon());
        System.out.println(userThread.isDaemon());
    }
}
