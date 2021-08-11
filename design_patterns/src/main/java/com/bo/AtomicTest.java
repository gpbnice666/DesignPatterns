package com.bo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicTest {
    private static AtomicInteger index = new AtomicInteger(10);

    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(10,1);

    private static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(65,1);


    public static void main(String[] args) {
        new Thread(()->{

            System.out.println(Thread.currentThread().getName()
                    +  " 现在的值为 "
                    + stampedReference.getReference()
                    + " 第一次版本号 "
                    + stampedReference.getStamp());

            boolean b = stampedReference.compareAndSet(22,
                    11,
                    reference.getStamp(),
                    reference.getStamp() + 1);

            System.out.println(Thread.currentThread().getName()
                    +  " 现在的值为 "
                    + stampedReference.getReference()
                    + " 第二次版本号 "
                    + stampedReference.getStamp());

            boolean b1 = stampedReference.compareAndSet(11,
                    10,
                    stampedReference.getStamp(),
                    stampedReference.getStamp() + 1);

            System.out.println(Thread.currentThread().getName()
                    +  " 现在的值为 "
                    + stampedReference.getReference()
                    + " 第三次版本号 "
                    + stampedReference.getStamp());
        },"张三").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);

                System.out.println(Thread.currentThread().getName()
                        +  " 现在的值为 "
                        + stampedReference.getReference()
                        + " 第一次版本号 "
                        + stampedReference.getStamp());

                boolean b = stampedReference.compareAndSet(10,
                        11,
                        stampedReference.getStamp(),
                        stampedReference.getStamp() + 1);

                System.out.println(Thread.currentThread().getName()
                        +  " 现在的值为 "
                        + stampedReference.getReference()
                        + " 第次版本号二 "
                        + stampedReference.getStamp());

                System.out.println(Thread.currentThread().getName()
                        + " 预期的值是10吗："
                        + b
                        + " 当前实际的值 "
                        + stampedReference.getReference());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"李四").start();

    }

    static void Aba(){
        new Thread(()->{
            boolean b = index.compareAndSet(10, 11);
            System.out.println(b+" index="+index);
            boolean b1 = index.compareAndSet(11, 10);
            System.out.println(b1+" index="+index);
            System.out.println(Thread.currentThread().getName()+"10->11->11");
        },"张三").start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    boolean b = index.compareAndSet(10, 12);
                    System.out.println(Thread.currentThread().getName()+"index的预期的值是10ma"+b+" index设置的值"+index);
                }catch (Exception e){

                }
            }
        },"李四").start();
    }
}
