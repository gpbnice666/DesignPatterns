package com.bo.thread.forkJoinPool;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author: gpb
 * @Date: 2023/4/27 10:04
 * @Description:
 */
public class ForkJoinPoolTest {

    public static void main (String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(()->{

        });
        System.out.println(forkJoinPool.getPoolSize());
    }

}
