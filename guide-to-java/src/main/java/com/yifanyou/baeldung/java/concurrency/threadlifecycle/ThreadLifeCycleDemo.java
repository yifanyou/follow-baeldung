package com.yifanyou.baeldung.java.concurrency.threadlifecycle;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/22/2019 10:43 PM
 * 功能描述:
 * 修改历史:
 */
public class ThreadLifeCycleDemo {

    public static void main(String[] args) {
        ThreadLifeCycleDemo demo = new ThreadLifeCycleDemo();

//        demo.produceNewState();

        demo.produceRunnableState();


    }

    public void produceNewState(){
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        System.out.println(t.getState());
    }

    public void produceRunnableState(){
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        t.start();
        System.out.println(t.getState());
    }
}
