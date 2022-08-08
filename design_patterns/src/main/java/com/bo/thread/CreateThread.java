package com.bo.thread;

import java.util.concurrent.*;

/**
 *
 * 线程大小计算公式
 * N_thread=N_cpu * U_cpu *(1+W/C)
 *
 * N_cpu: 处理器核数 通过 Runtime.getRuntime().availableProcessors()获取
 * U_cpu: 利用率,介于0-1之间
 * W/C:   等待时间于计算时间的比率
 *
 * JAVA的线程状态
 * NEW(new)   线程刚刚创建,还没启动
 * RUNNABLE(runnable)  可运行状态,由线程调度器可以安排执行
 * WAITING(waiting)     等待被唤醒
 * TIMED WAITING(timed waiting)  隔一段时间后自动唤醒
 * BLOCKED(blocked)     被阻塞,正在等待锁
 * TERMINATE(terminate)  线程结束
 *
 *
 * @author gpb
 * @date 2022/7/21 15:15
 */
public class CreateThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 继承Thread
        new MyThread().start();
        // 实现 Runnable
        new Thread(new MyRunnable()).start();
        //  lambda接口
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()  +" Hello lambda");
        }).start();

        Thread thread = new Thread();
        thread.getState();
        thread.stop();
        // 实现 Callable,通过FutureTask包装Callable 给 Thread
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        System.out.println("Callable 的返回" + futureTask.get());

        // 通过线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName()  +" Hello ExecutorService");
        });

        // 通过 submit 提交任务
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println("Callable 的返回" + future.get());

    }

    /**
     * 继承thread类 重写run方法
     */
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()  + " Hello MyThread");
            super.run();
        }
    }

    /**
     * 实现Runnable接口,实现run方法
     */
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()  +" Hello MyRunnable");
        }
    }

    /**
     * 实现MyCallable接口,实现call,可以返回值
     */
    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()  +" Hello MyCallable");
            return "success";
        }
    }

    /**
     * 停止线程 suspend() and  resume
     */
    public static class Suspend_Resume{
        public static void main(String[] args)  {
            Thread thread = new Thread(()->{
                while (true){
                    System.out.println("run");
                    SleepHelper.sleepSeconds(1);
                }
            });

            thread.start();
            SleepHelper.sleepSeconds(5);
            // 停止线程
            thread.suspend();
            SleepHelper.sleepSeconds(3);
            // 继续执行
            thread.resume();
        }
    }

    /**
     * 停止线程 volatile标识
     */
    public static class Volatile{
        /**
         * 线程开关
         */
        public static volatile boolean run=true;

        public static void main(String[] args)  {
            Thread thread = new Thread(()->{
                while (run){
                    System.out.println("run");
                    SleepHelper.sleepSeconds(1);
                }
                System.out.println("thread end");
            });

            thread.start();
            SleepHelper.sleepSeconds(5);
            // 停止线程
            run=false;
        }
    }


    /**
     * 停止线程 volatile标识
     */
    public static class Interrupt{

        public static void main(String[] args)  {
            Thread thread = new Thread(()->{
                // Thread.interrupted() 获取是否有标志位,如果有就会重新设置
                // interrupted 和 sleep wait join 使用有异常
                while (!Thread.interrupted()){
                    System.out.println("run");
                }

                System.out.println("thread end");
            });

            thread.start();
            SleepHelper.sleepSeconds(5);
            // 设置中断标识
            thread.interrupt();
        }
    }

    /**
     *  Volatile 保证线程的可见性
     *  volatile 修饰类型：引用类型(包括数组),只能保证本身的可见性,不能保证内部字段的可见性
     */
    public static class ThreadVolatile{

        /**
         * running 如果不用volatile去修饰,线程每次读取值的时候都是在自己的线程本地缓存中读取
         * running 用volatile去修饰,线程每次读取值的时候都是在主内存中读取值
         */
        public static volatile boolean running = true;

        private static void m(){
            System.out.println("m start");
            while (running) {
                // 如果又被 synchronized 修饰 也会触发内存缓存刷新
               // System.out.println("hello ");
            }
            System.out.println("m end");
        }

        public static void main(String[] args) {
            // 启动线程
            new Thread(ThreadVolatile::m,"t1").start();

            SleepHelper.sleepSeconds(2);

            running = false;
        }

    }

    /**
     * 睡眠工具类
     */
    public static class SleepHelper{
        public static void sleepSeconds(long timeout){
            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
