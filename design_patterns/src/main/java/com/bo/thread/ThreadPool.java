package com.bo.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gpb
 */
public class ThreadPool {

    // 阻塞队列实现生产者-消费者
    BlockingQueue<Runnable> taskQueue;

    // 工作线程集合
    List<Thread> threads = new ArrayList<Thread>();

    public ThreadPool(int poolSize,BlockingQueue<Runnable> taskQueue){

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        this.taskQueue = taskQueue;

        for (int i = 0; i <poolSize; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    Runnable task;
                    try {
                        task = taskQueue.take();//获取任务队列中的下一个任务
                        task.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            threads.add(t);
        }
    }

    void execute(Runnable task){
        try {
            // 把任务放到队列
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

}
