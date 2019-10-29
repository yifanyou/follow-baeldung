package com.yifanyou.baeldung.java.concurrency.threadlocal;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/20/2019 10:56 PM
 * 功能描述:
 * 修改历史:
 */
public class Context {
    private final String userName;

    Context(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Context{" +
                "userNameSecret='" + userName + '\'' +
                '}';
    }
}
