package com.bo.behaviourPatterns.mediator.mediatorImpl;

import com.bo.behaviourPatterns.mediator.Colleague;
import com.bo.behaviourPatterns.mediator.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gpb
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}