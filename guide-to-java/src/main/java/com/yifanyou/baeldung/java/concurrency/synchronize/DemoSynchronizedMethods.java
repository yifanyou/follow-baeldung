package com.yifanyou.baeldung.java.concurrency.synchronize;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 9/16/2019 10:53 PM
 * 功能描述:
 * 修改历史:
 */
public class DemoSynchronizedMethods {
    private int sum = 0;
    private int syncSum = 0;

    static int staticSum = 0;

    void calculate() {
        setSum(getSum() + 1);
    }

    synchronized void synchronisedCalculate() {
        setSyncSum(getSyncSum() + 1);
    }

    static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    int getSyncSum() {
        return syncSum;
    }

    private void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }
}
