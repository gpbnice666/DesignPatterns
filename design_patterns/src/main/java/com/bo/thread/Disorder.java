package com.bo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 乱序
 * @author gpb
 * @date 2022/7/22 15:55
 */
public class Disorder {

    public static  int x = 0,y = 0;
    public static  int a = 0,b = 0;

    /**
     * 排列组合
     * 1. a=1
     *    x=b
     *         b=1
     *         y=a
     *    x=0  y=1
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < Long.MAX_VALUE; i++){
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch countDownLatch = new CountDownLatch(2);

            Thread one = new Thread(() -> {
                a = 1;
                x = b;

                countDownLatch.countDown();
            });

            Thread other = new Thread(() -> {
                b = 1;
                y = a;
                countDownLatch.countDown();
            });
            one.start();
            other.start();
            countDownLatch.await();
            String result = "第" + i + "次" + "(" + x + "," + y + ")";

            if(x==0 && y==0){
                System.out.println(result);
                break;
            }

        }
    }


}
