package com.bo.behaviourPatterns.mediator;

/**
 * @author gpb
 * 抽象中介者
 */
public abstract class Mediator {

    public abstract void register(Colleague colleague);

    /**
     * 转发
     * @param colleague
     */
    public abstract void relay(Colleague colleague);

}
