package com.bo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author gpb
 * @date 2021/10/19 18:03
 */
public class MyThreadPoolExecutor {

    //最大可用的CPU核数
    public static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    //线程最大的空闲存活时间，单位为秒
    public static final int KEEPALIVETIME = 60;
    //任务缓存队列长度
    public static final int BLOCKINGQUEUE_LENGTH = 500;

    public ThreadPoolExecutor createThreadPool() {
        return new ThreadPoolExecutor(PROCESSORS * 2, PROCESSORS * 4, KEEPALIVETIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(BLOCKINGQUEUE_LENGTH));
    }


}
