package com.yifanyou.baeldung.java.concurrency.waitandnotify;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/11/2019 11:27 PM
 * 功能描述:
 * 修改历史:
 */
public class WaitAndNotifyDemo {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
