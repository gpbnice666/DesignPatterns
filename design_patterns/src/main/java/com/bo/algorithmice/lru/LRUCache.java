package com.bo.algorithmice.lru;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.SmartInitializingSingleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过Hash 和 双向链表 实现 LRU
 * @author gpb
 * @date 2021/12/8 22:24
 */
public class LRUCache {

    class Node<K, V> {
        K key;
        V value;
        // 后指针
        Node<K, V> next;
        // 前指针
        Node<K, V> prev;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        // 头节点
        Node<K, V> head;
        // 尾部节点
        Node<K, V> tail;

        /**
         * head              tail
         * -----   next-->    -----
         * |    |          |      |
         * |    |          |     |
         * -----   <-- prev------
         */
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public Node<K, V> getLast() {
            return tail.prev;
        }

    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>(); // 查找
        doubleLinkedList = new DoubleLinkedList<>(); // 存储
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 包含修改
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == cacheSize) {
                Node<Integer, Integer> last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            // 新增
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);

        System.out.println(lruCache.map.keySet());
        lruCache.put(3,3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(4,4);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3,3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(5,5);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3,3);
        System.out.println(lruCache.map.keySet());

    }
}

