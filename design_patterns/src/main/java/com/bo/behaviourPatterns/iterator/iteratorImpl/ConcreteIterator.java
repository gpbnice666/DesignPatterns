package com.bo.behaviourPatterns.iterator.iteratorImpl;

import com.bo.behaviourPatterns.iterator.Iterator;

import java.util.List;

/**
 * @author gpb
 * 具体的迭代器
 */
public class ConcreteIterator implements Iterator {

    private List<Object> list = null;

    private int index = -1;

    public ConcreteIterator(List<Object> list){
        this.list = list;
    }

    @Override
    public Object first() {
        return list.get(0);
    }

    @Override
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if(index < list.size()-1)
            return true;
        return false;
    }
}
