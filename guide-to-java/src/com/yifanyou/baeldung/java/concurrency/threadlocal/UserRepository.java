package com.yifanyou.baeldung.java.concurrency.threadlocal;

import java.util.UUID;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/20/2019 10:58 PM
 * 功能描述:
 * 修改历史:
 */
public class UserRepository {
    String getUserNameForUserId(Integer userId) {
        return UUID.randomUUID().toString();
    }
}
