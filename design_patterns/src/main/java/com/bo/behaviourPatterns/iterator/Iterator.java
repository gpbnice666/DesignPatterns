package com.bo.behaviourPatterns.iterator;

/**
 * @author gpb
 * 抽象迭代器
 */
public interface Iterator {

    Object first();

    Object next();

    boolean hasNext();

}
