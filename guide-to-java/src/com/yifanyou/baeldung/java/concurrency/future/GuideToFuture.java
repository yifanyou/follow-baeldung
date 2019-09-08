package com.yifanyou.baeldung.java.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/8/2019 9:17 PM
 * 功能描述:
 * 修改历史:
 */
public class GuideToFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Using isDone() and get() to Obtain Results
//        test1();

        //Canceling a Future with cancel()
//        test2();

        //More Multithreading with Thread Pools
//        test31();
//        test32();

        //ForkJoinTask
        test4();
    }

    static void test1() throws InterruptedException, ExecutionException {
        Future<Integer> future = new SquareCalculator().calculate(10);

        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        System.out.println("Calculate result: " + result);
    }

    static void test2() {
        Future<Integer> future = new SquareCalculator().calculate(4);

        boolean canceled = future.cancel(true);
        System.out.println("Calculate canceled: " + canceled);
    }

    static void test31() throws InterruptedException, ExecutionException {
        System.out.println("test31 单线程");

        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        squareCalculator.shutdown();
    }

    static void test32() throws InterruptedException, ExecutionException {
        System.out.println("test32 多线程");

        FixedThreadPoolSquareCalculator squareCalculator = new FixedThreadPoolSquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        squareCalculator.shutdown();
    }

    static void test4() throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

        forkJoinPool.execute(calculator);

        Integer result = calculator.get();

        System.out.println("fork join result: " + result);
    }
}
