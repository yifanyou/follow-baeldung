package com.yifanyou.baeldung.java.concurrency.runnablecallable;

import java.util.concurrent.Callable;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/12/2019 11:18 PM
 * 功能描述:
 * 修改历史:
 */
public class FactorialTask implements Callable<Integer> {
    int number;

    // standard constructors
    public FactorialTask(Integer number){
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }
}
