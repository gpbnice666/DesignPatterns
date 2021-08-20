package com.bo.behaviourPatterns.iterator.aggregateImpl;

import com.bo.behaviourPatterns.iterator.Aggregate;
import com.bo.behaviourPatterns.iterator.Iterator;
import com.bo.behaviourPatterns.iterator.iteratorImpl.ConcreteIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gpb
 * 具体聚合
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return  new  ConcreteIterator(list);
    }
}
