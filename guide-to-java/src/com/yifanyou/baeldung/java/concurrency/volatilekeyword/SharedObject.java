package com.yifanyou.baeldung.java.concurrency.volatilekeyword;

/**
 * 版权：    上海云砺信息科技有限公司
 * 创建者:   youyifan
 * 创建时间: 9/17/2019 11:32 PM
 * 功能描述:
 * 修改历史:
 */
public class SharedObject {
    private volatile int count=0;

    public void increamentCount(){
        count++;
        System.out.println(count);
    }
    public int  getCount(){
        return count;
    }
}
