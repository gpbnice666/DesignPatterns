package com.bo.behaviourPatterns.observer;

/**
 * @author gpb
 * 通知者接口
 * 　首先定义一个观察者数组，并实现增、删及通知操作。它的职责很简单，就是定义谁能观察，谁不能观察
 */
public interface Subject {

    /**
     * 增加
     * @param observer
     */
    public void attach(Observer observer);

    /**
     * 删除方法
     * @param observer
     */
    public void detach(Observer observer);

    /**
     * 通知
     */
    public void notifyObservers();

    /**
     * 状态
     * @param action
     */
    public void setAction(String action);

    public String getAction();

}
