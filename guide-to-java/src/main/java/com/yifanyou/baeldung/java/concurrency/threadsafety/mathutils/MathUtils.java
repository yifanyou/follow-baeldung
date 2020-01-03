package com.yifanyou.baeldung.java.concurrency.threadsafety.mathutils;

import java.math.BigInteger;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:10 PM
 * 功能描述:
 * 修改历史:
 */
public class MathUtils {
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
