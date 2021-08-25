package com.bo.behaviourPatterns.visitor;

/**
 * @author gpb
 * 抽象元素类
 */
public interface Element {

    void accept(Visitor visitor);

    String  operation();

}
