package com.yifanyou.baeldung.java.concurrency.future;

import java.util.concurrent.RecursiveTask;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/8/2019 9:57 PM
 * 功能描述:
 * 修改历史:
 */
public class FactorialSquareCalculator  extends RecursiveTask<Integer> {
    private Integer n;

    public FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator
                = new FactorialSquareCalculator(n - 1);

        calculator.fork();

        return n * n + calculator.join();
    }
}
