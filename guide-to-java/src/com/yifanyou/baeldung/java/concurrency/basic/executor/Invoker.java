package com.yifanyou.baeldung.java.concurrency.basic.executor;

import java.util.concurrent.Executor;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/15/2019 8:08 PM
 * 功能描述:
 * 修改历史:
 */
public class Invoker implements Executor{
    @Override
    public void execute(Runnable r) {
        r.run();
    }
}
