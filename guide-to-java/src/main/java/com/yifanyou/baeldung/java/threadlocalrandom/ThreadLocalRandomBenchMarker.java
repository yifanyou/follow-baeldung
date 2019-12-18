package com.yifanyou.baeldung.java.threadlocalrandom;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 版权：    blog.yifanyou.com
 * 创建者:   youyifan
 * 创建时间: 12/18/2019 5:04 PM
 * 功能描述: IDEA需要安装JMH-PLUGIN,windows上执行的时候要锁c盘windows目录下的文件导致失败，我最后在命令行执行。
 * 修改历史:
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class ThreadLocalRandomBenchMarker {

    List<Callable<Integer>> randomCallables = new ArrayList<>();
    List<Callable<Integer>> threadLocalRandomCallables = new ArrayList<>();

    @Setup(Level.Iteration)
    public void init() {
        Random random = new Random();
        randomCallables = new ArrayList<>();
        threadLocalRandomCallables = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            randomCallables.add(() -> {
                return random.nextInt();
            });
        }

        for (int i = 0; i < 1000; i++) {
            threadLocalRandomCallables.add(() -> {
                return ThreadLocalRandom.current()
                        .nextInt();
            });
        }
    }

    @Benchmark
    public void randomValuesUsingRandom() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        executor.invokeAll(randomCallables);
        executor.shutdown();
    }

    @Benchmark
    public void randomValuesUsingThreadLocalRandom() throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        executor.invokeAll(threadLocalRandomCallables);
        executor.shutdown();
    }

}
