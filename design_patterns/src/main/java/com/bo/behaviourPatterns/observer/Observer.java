package com.bo.behaviourPatterns.observer;


/**
 * @author gpb
 * 观察者
 * 观察者一般是一个接口，每一个实现该接口的实现类都是具体观察者。
 */
public abstract class Observer {

    public String name;

    public Subject subject;

    public Observer(String name,Subject subject){
        this.name = name;
        this.subject = subject;
    }

    /**
     * 更新方法
     */
    public abstract void update();



}
