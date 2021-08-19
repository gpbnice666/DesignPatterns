package com.bo.thread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TestOrderliness {
    
    static int x;//静态变量 x
    static int y;//静态变量 y
    //计数变量
    static volatile   int count = 0;
    private static AtomicInteger index = new AtomicInteger(0);
    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(0,0);


    public static void main(String[] args) throws InterruptedException {
        tessAtomic();
        testOrderLiness();
        Executor executor;
        executor = new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
    }


    public static void tessAtomic() throws InterruptedException {
        //线程 1 给 count 加 10000
        Thread t1 = new Thread(() -> {
            for (int j = 0; j <100000; j++) {
                count++;
                index.compareAndSet(index.get(),index.get()+1);
            }
            System.out.println("thread t1 count 加 10000 结束");
        });

        //线程 2 给 count 加 10000
        Thread t2 = new Thread(() -> {
            for (int j = 0; j <100000; j++) {
                count++;
                index.compareAndSet(index.get(),index.get()+1);
            }
            System.out.println("thread t2 count 加 10000 结束");
        });

        //启动线程 1
        t1.start();
        //启动线程 2
        t2.start();

        //等待线程 1 执行完成
        t1.join();
        //等待线程 2 执行完成
        t2.join();

        //打印 count 变量
        System.out.println(count);
        System.out.println(index.get());
    }

    public static void testOrderLiness() throws InterruptedException {
        Set<String> valueSet = new HashSet<String>();//记录出现的结果的情况
        Map<String, Integer> valueMap = new HashMap<String, Integer>();//存储结果的键值对

        //循环 1000 万次，记录可能出现的 v1 和 v2 的情况
        for (int i = 0; i <100000; i++) {
            //给 x y 赋值为 0
            x = 0;
            y = 0;
            valueMap.clear();//清除之前记录的键值对
            Thread t1 = new Thread(() -> {
                int v1 = y;//将 y 赋值给 v1 ----> Step1
                x = 1;//设置 x 为 1  ----> Step2
                valueMap.put("v1", v1);//v1 值存入 valueMap 中  ----> Step3
            }) ;

            Thread t2 = new Thread(() -> {
                int v2 = x;//将 x 赋值给 v2  ----> Step4
                y = 1;//设置 y 为 1  ----> Step5
                valueMap.put("v2", v2);//v2 值存入 valueMap 中  ----> Step6
            });

            //启动线程 t1 t2
            t1.start();
            t2.start();
            //等待线程 t1 t2 执行完成
            t1.join();
            t2.join();

            //利用 Set 记录并打印 v1 和 v2 可能出现的不同结果
            valueSet.add("(v1=" + valueMap.get("v1") + ",v2=" + valueMap.get("v2") + ")");
            System.out.println(valueSet);
        }
    }
    
}