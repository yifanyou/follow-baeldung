package com.yifanyou.baeldung.java.concurrency.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/11/2019 11:25 PM
 * 功能描述:
 * 修改历史:
 */
public class Sender implements Runnable {
    private Data data;

    // standard constructors
    public Sender(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted " + e.getMessage());
            }
        }
    }
}
