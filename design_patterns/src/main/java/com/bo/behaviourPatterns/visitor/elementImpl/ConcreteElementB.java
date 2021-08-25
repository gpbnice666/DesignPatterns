package com.bo.behaviourPatterns.visitor.elementImpl;

import com.bo.behaviourPatterns.visitor.Element;
import com.bo.behaviourPatterns.visitor.Visitor;
import com.bo.behaviourPatterns.visitor.visitorImpl.ConcreteVisitorA;

/**
 * @author gpb
 * 具体元素B
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String operation() {
        return "具体元素B的操作";
    }
}
