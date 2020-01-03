package com.yifanyou.baeldung.java.concurrency.threadsafety;

import com.yifanyou.baeldung.java.concurrency.threadsafety.mathutils.MathUtils;
import org.junit.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 1/3/2020 12:01 PM
 * 功能描述:
 * 修改历史:
 */
public class MathUtilsUnitTest {

    @Test
    public void whenCalledFactorialMethod_thenCorrect() {
        assertThat(MathUtils.factorial(2)).isEqualTo(new BigInteger("2"));
    }

}
