package com.bo.behaviourPatterns.mediator;

/**
 * @author gpb
 * 抽象同事类
 */
public abstract class Colleague {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract void send();
}
