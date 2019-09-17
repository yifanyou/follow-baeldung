package com.yifanyou.baeldung.java.concurrency.volatilekeyword;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/17/2019 11:32 PM
 * 功能描述:
 * 修改历史:
 */
public class VolatileDemo {
    /**
     * 虽然打印出来的count不是顺序的，但是得到的结果是正确的。
     * 说明每一次计算，线程拿到的count的值都是最新的。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedObject sharedObject = new SharedObject();

        IntStream.range(0, 20)
                .forEach(count -> service.submit(sharedObject::increamentCount));
        service.awaitTermination(2000, TimeUnit.MILLISECONDS);

        System.out.println(sharedObject.getCount());
    }
}
