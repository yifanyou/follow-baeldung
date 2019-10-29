package com.yifanyou.baeldung.java.concurrency.interrupt;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   youyifan
 * 创建时间: 10/5/2019 2:51 PM
 * 功能描述:
 * 修改历史:
 */
public class ControlSubThreadTwo implements Runnable {

    private Thread worker;
    private AtomicBoolean running = new AtomicBoolean(false);
//    private AtomicBoolean stopped = new AtomicBoolean(true);

    private int interval;

    public ControlSubThreadTwo(int sleepInterval) {
        interval = sleepInterval;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

//    boolean isStopped() {
//        return stopped.get();
//    }

    @Override
    public void run() {
        running.set(true);
//        stopped.set(false);
        while (running.get()) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(
                        "Thread was interrupted, Failed to complete operation");
            }
            // do something
        }
//        stopped.set(true);
    }
}
