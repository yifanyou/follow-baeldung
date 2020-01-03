package com.yifanyou.baeldung.java.concurrency.threadsafety.application;

import com.yifanyou.baeldung.java.concurrency.threadsafety.callables.*;
import com.yifanyou.baeldung.java.concurrency.threadsafety.mathutils.MathUtils;
import com.yifanyou.baeldung.java.concurrency.threadsafety.services.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:05 PM
 * 功能描述:
 * 修改历史:
 */
public class Application {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        new Thread(() -> {
            System.out.println(MathUtils.factorial(10));
        }).start();
        new Thread(() -> {
            System.out.println(MathUtils.factorial(5));
        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MessageService messageService = new MessageService("Welcome to Baeldung!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        System.out.println(future1.get());
        System.out.println(future2.get());

        Counter counter = new Counter();
        Future<Integer> future3 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
        Future<Integer> future4 = (Future<Integer>) executorService.submit(new CounterCallable(counter));
        System.out.println(future3.get());
        System.out.println(future4.get());

        ExtrinsicLockCounter extrinsicLockCounter = new ExtrinsicLockCounter();
        Future<Integer> future5 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(extrinsicLockCounter));
        Future<Integer> future6 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(extrinsicLockCounter));
        System.out.println(future5.get());
        System.out.println(future6.get());

        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        Future<Integer> future7 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        Future<Integer> future8 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(reentrantLockCounter));
        System.out.println(future7.get());
        System.out.println(future8.get());

        ReentrantReadWriteLockCounter reentrantReadWriteLockCounter = new ReentrantReadWriteLockCounter();
        Future<Integer> future9 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        Future<Integer> future10 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(reentrantReadWriteLockCounter));
        System.out.println(future9.get());
        System.out.println(future10.get());

        AtomicCounter atomicCounter = new AtomicCounter();
        Future<Integer> future11 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        Future<Integer> future12 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        System.out.println(future11.get());
        System.out.println(future12.get());

        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread11 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread thread12 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        thread11.start();
        thread12.start();

        Map<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");
    }
}
