package com.bo.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gpb
 * @date 2021/10/19 18:05
 */
public class CreateThreads {

    public synchronized static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(MyThreadPoolExecutor.PROCESSORS);
        new CreateThreads().test();

        System.out.println(System.currentTimeMillis() - start);
    }

    public synchronized void test(){
        ThreadPoolExecutor threadPoolExecutor=new MyThreadPoolExecutor().createThreadPool();
        for (int i = 0; i <= 10000; i++) {
            MyTask myTask = new MyTask(i);
            threadPoolExecutor.execute(myTask);
        }
        threadPoolExecutor.shutdown();
    }

}

class MyTask implements Runnable{
    private int i;

    public MyTask(int i){
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println("任务"+i+"开始执行"+System.currentTimeMillis());
        for (int i=0;i<32766;i++){
            Random random=new Random();
            int randNum=random.nextInt();
            int[] a={1,2,3,4,5,6,9,18,290,238,991,100,19,1932,randNum};
            Arrays.sort(a);
            Arrays.hashCode(a);
            Arrays.stream(a);
        }
        System.out.println("任务"+i+"结束执行"+System.currentTimeMillis());
    }

}
