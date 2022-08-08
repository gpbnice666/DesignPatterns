package com.bo.algorithmice.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gpb
 * @date 2021/12/8 22:11
 */
public class LRUCacheLinkedHashMap<K,V>  extends LinkedHashMap<K,V> {

    /**
     * 缓存的大小
     */
    private int capacity;


    /**
     * super(capacity,0.75F,true);
     * 为true的时候 如果要添加数据的时候 要添加的数据 会删除 在尾部追加
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 4, 3]
     * [2, 4, 3]
     * [2, 4, 3]
     * [4, 3, 5]
     * ------------
     * super(capacity,0.75F,false);
     * 如果false 如果存在就不会添加了
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [3, 4, 5]
     * @param capacity
     */
    public LRUCacheLinkedHashMap(int capacity){
        super(capacity,0.75F,false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap<Object, Object> lru = new LRUCacheLinkedHashMap<>(3);
        lru.put(1,"111");
        lru.put(2,"222");
        lru.put(3,"333");

        System.out.println(lru.keySet());

        lru.put(4,"444");
        System.out.println(lru.keySet());
        lru.put(3,"333");
        System.out.println(lru.keySet());
        lru.put(3,"333");
        System.out.println(lru.keySet());
        lru.put(3,"333");
        System.out.println(lru.keySet());
        lru.put(5,"555");
        System.out.println(lru.keySet());
    }

}
