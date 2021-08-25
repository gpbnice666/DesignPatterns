package com.bo.behaviourPatterns.visitor.visitorImpl;

import com.bo.behaviourPatterns.visitor.Element;
import com.bo.behaviourPatterns.visitor.Visitor;

/**
 * @author gpb
 * 具体访问者
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(Element element) {
        System.out.println("具体访问者B访问-->" + element.operation());
    }
}
