package com.yifanyou.baeldung.java.concurrency.threadlocal;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/20/2019 10:59 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadLocalWithUserContext implements Runnable{

    private static final ThreadLocal<Context> userContext = new ThreadLocal<>();
    private final Integer userId;
    private UserRepository userRepository = new UserRepository();

    ThreadLocalWithUserContext(Integer userId) {
        this.userId = userId;
    }


    @Override
    public void run() {
        String userName = userRepository.getUserNameForUserId(userId);
        userContext.set(new Context(userName));
        System.out.println("thread context for given userId: " + userId + " is: " + userContext.get());
    }
}
