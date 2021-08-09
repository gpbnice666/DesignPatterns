package com.bo.behaviourPatterns.observer.subject;

import com.bo.behaviourPatterns.observer.Observer;
import com.bo.behaviourPatterns.observer.Subject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gpb
 * 具体的通知者 老板通知
 */
public class Boss implements Subject {
    // 同事列表
    private List<Observer> observerList = new LinkedList<>();

    // 添加
    private String action;

    @Override
    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        this.observerList.forEach(observer -> {
            observer.update();
        });
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getAction() {
        return action;
    }
}
