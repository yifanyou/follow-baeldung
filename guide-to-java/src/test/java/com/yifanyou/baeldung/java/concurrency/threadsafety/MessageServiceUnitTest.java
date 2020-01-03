package com.yifanyou.baeldung.java.concurrency.threadsafety;

import com.yifanyou.baeldung.java.concurrency.threadsafety.callables.MessageServiceCallable;
import com.yifanyou.baeldung.java.concurrency.threadsafety.services.MessageService;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:01 PM
 * 功能描述:
 * 修改历史:
 */
public class MessageServiceUnitTest {
    @Test
    public void whenCalledgetMessage_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MessageService messageService = new MessageService("Welcome to Baeldung!");
        Future<String> future1 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));
        Future<String> future2 = (Future<String>) executorService.submit(new MessageServiceCallable(messageService));

        assertThat(future1.get()).isEqualTo("Welcome to Baeldung!");
        assertThat(future2.get()).isEqualTo("Welcome to Baeldung!");
    }
}
