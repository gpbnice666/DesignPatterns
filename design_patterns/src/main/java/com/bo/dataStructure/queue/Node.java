package com.bo.dataStructure.queue;

/**
 * @author gpb
 * @param <T>
 *     节点
 */
public class Node<T> {

    // 存储的数据
    private T data;
    // 下一个节点的引用
    private Node<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node(T date){
        this.data = date;
    }
}