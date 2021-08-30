package com.bo.dataStructure.queue;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {

    public static void main(String[] args) {
        Queue queues = new ConcurrentLinkedQueue();
        for (int i = 0; i < queues.size(); i++) {

        }
        LinkQueue<Integer> queue  = new LinkQueue<>();
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println("size：" + queue.size());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("size：" + queue.size());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("size：" + queue.size());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("size：" + queue.size());
        System.out.println("出队列：" + queue.deQueue());
        System.out.println("size：" + queue.size());
    }

}