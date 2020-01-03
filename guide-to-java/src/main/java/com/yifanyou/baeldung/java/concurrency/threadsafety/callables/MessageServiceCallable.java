package com.yifanyou.baeldung.java.concurrency.threadsafety.callables;

import com.yifanyou.baeldung.java.concurrency.threadsafety.services.MessageService;

import java.util.concurrent.Callable;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:12 PM
 * 功能描述:
 * 修改历史:
 */
public class MessageServiceCallable implements Callable<String> {
    private final MessageService messageService;

    public MessageServiceCallable(MessageService messageService) {
        this.messageService = messageService;

    }

    @Override
    public String call() {
        return messageService.getMesssage();
    }
}
