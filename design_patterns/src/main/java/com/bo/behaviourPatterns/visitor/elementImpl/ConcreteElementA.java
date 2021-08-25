package com.bo.behaviourPatterns.visitor.elementImpl;

import com.bo.behaviourPatterns.visitor.Element;
import com.bo.behaviourPatterns.visitor.Visitor;

/**
 * @author gpb
 * 具体元素A
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "具体元素A的操作";
    }
}
