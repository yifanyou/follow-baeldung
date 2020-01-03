package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:08 PM
 * 功能描述:
 * 修改历史:
 */
public class StateHolder {
    private final String state;

    public StateHolder(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
