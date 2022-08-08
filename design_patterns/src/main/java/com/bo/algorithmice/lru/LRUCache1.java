package com.bo.algorithmice.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 * lru算法 就是 缓存删除数据算法
 * 解题思路：
 * LRU 总体上是这样的，最近使用的放在前边（最左边），最近没用的放到后边（最右边），
 * 来了一个新的数，如果内存满了，把旧的数淘汰掉，那位了方便移动数据，
 * 我们肯定不能考虑用数组，呼之欲出，就是使用链表了，解决方案：链表（处理新老关系）+ 哈希（查询在不在），分析如下
 *
 * 底层应该用链表，按照数据的新旧程度来排列，旧的在左边，新的在右边，
 * 新来一个加到尾部（你可以想象自己从左往右画一条链表），删除是删头,除了这两个操作，
 * 还有就是把一个数据从中间拿出来放尾巴上（这个数组就很难做到）
 *
 * 这里还有一个需求，就是要知道这个数据有没有存在于链表中，如果不在链表中
 * ，加到尾巴即可，如果已经在链表中，就只要更细数据的位置,如何查找这个数据在不在呢，这就用哈希表。
 *
 * 考虑删除操作，要把当前节点的前一个节点的指针的改变，获取它前一个节点，方便的数据结构就是 双向链表
 *
 * 作者：jerry_nju
 * 链接：https://leetcode-cn.com/problems/lru-cache-lcci/solution/linkedhashmap-shuang-lian-biao-hashmap-dan-lian-2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author gpb
 * @date 2021/12/8 22:01
 */
public class LRUCache1 {
    public class LRUCache{
        int capacity;
        Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 先删除旧的位置，再放入新位置
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }


        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            map.put(key, value);
            // 超出capacity，删除最久没用的,利用迭代器删除第一个
            if (map.size() > capacity) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
        }
    }


}
