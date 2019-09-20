package com.yifanyou.baeldung.java.concurrency.threadlocal;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/20/2019 11:00 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo demo = new ThreadLocalDemo();

//        demo.testSharedMap();

        demo.testThreadLocal();
    }

    void testSharedMap() throws InterruptedException {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        Thread first = new Thread(firstUser);
        Thread second = new Thread(secondUser);
        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(SharedMapWithUserContext.userContextPerUserId.size());
    }

    void testThreadLocal() {
        ThreadLocalWithUserContext firstUser
                = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser
                = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
    }
}
