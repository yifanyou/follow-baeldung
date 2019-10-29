package com.yifanyou.baeldung.java.concurrency.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/16/2019 10:54 PM
 * 功能描述:
 * 修改历史:
 */
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
//        synchronizedDemo.givenMultiThread_whenNonSyncMethod();

//        synchronizedDemo.givenMultiThread_whenMethodSync();

//        synchronizedDemo.givenMultiThread_whenStaticSyncMethod();

//        synchronizedDemo.givenMultiThread_whenBlockSync();

        synchronizedDemo.givenMultiThread_whenStaticSyncBlock();
    }

    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        DemoSynchronizedMethods summation = new DemoSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        System.out.println(summation.getSum());
    }

    public void givenMultiThread_whenMethodSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        DemoSynchronizedMethods method = new DemoSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(method::synchronisedCalculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        System.out.println(method.getSyncSum());
    }

    public void givenMultiThread_whenStaticSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(DemoSynchronizedMethods::syncStaticCalculate));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.println(DemoSynchronizedMethods.staticSum);
    }

    public void givenMultiThread_whenBlockSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        DemoSynchronizedBlocks synchronizedBlocks = new DemoSynchronizedBlocks();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(synchronizedBlocks::performSynchronisedTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.println(synchronizedBlocks.getCount());
    }

    public void givenMultiThread_whenStaticSyncBlock() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(DemoSynchronizedBlocks::performStaticSyncTask));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.println(DemoSynchronizedBlocks.getStaticCount());
    }
}
