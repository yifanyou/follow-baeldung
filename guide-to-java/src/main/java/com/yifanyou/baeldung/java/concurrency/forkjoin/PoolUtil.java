package com.yifanyou.baeldung.java.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 11/18/2019 5:21 PM
 * 功能描述:
 * 修改历史:
 */
public class PoolUtil {
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(2);
}
