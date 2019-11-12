package com.yifanyou.baeldung.java.concurrency.runnablecallable;

import java.util.concurrent.Callable;
import java.security.InvalidParameterException;
/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/12/2019 11:18 PM
 * 功能描述:
 * 修改历史:
 */
public class FactorialTaskWithExceptionHandle implements Callable<Integer> {
    int number;

    // standard constructors
    public FactorialTaskWithExceptionHandle(Integer number){
        this.number = number;
    }

    @Override
    public Integer call() throws InvalidParameterException {
        if(number < 0) {
            throw new InvalidParameterException("Number should be positive");
        }

        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }
}
