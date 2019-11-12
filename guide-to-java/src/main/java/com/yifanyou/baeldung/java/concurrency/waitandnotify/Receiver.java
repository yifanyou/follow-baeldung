package com.yifanyou.baeldung.java.concurrency.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/11/2019 11:26 PM
 * 功能描述:
 * 修改历史:
 */
public class Receiver implements Runnable {
    private Data load;

    // standard constructors
    public Receiver(Data data){
        this.load = data;
    }

    @Override
    public void run() {
        for(String receivedMessage = load.receive();
            !"End".equals(receivedMessage);
            receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " + e.getMessage());
            }
        }
    }
}
