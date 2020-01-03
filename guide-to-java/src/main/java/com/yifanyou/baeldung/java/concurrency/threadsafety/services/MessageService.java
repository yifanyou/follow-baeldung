package com.yifanyou.baeldung.java.concurrency.threadsafety.services;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:07 PM
 * 功能描述:
 * 修改历史:
 */
public class MessageService {
    private final String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String getMesssage() {
        return message;
    }
}
