package com.bo.behaviourPatterns.iterator;

/**
 * @author gpb
 * 抽象聚合
 */
public interface Aggregate {

    void add(Object obj);

    void remove(Object obj);

    Iterator getIterator();
}
