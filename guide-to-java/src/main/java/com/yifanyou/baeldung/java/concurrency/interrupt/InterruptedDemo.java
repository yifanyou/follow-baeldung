package com.yifanyou.baeldung.java.concurrency.interrupt;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 10/5/2019 2:59 PM
 * 功能描述:
 * 修改历史:
 */
public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        //线程controlSubThreadOne的sleepInterval为1s，启动后，等待2s再停止线程controlSubThreadOne，观察日志。
//        ControlSubThreadOne controlSubThreadOne = new ControlSubThreadOne(1000);
//        controlSubThreadOne.start();
//        Thread.sleep(2000);
//        controlSubThreadOne.stop();

        //线程controlSubThreadTwo的sleepInterval为1s，启动后，等待2s再中断线程controlSubThreadTwo，观察。
        ControlSubThreadTwo controlSubThreadTwo = new ControlSubThreadTwo(1000);
        controlSubThreadTwo.start();
        Thread.sleep(2000);
        controlSubThreadTwo.interrupt();

    }
}
