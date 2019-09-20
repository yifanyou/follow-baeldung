package com.yifanyou.baeldung.java.concurrency.threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/20/2019 10:57 PM
 * 功能描述:
 * 修改历史:
 */
public class SharedMapWithUserContext implements Runnable {
    public static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();
    private Integer userId;
    private UserRepository userRepository = new UserRepository();

    SharedMapWithUserContext(Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContextPerUserId.put(userId, new Context(userName));
    }
}
