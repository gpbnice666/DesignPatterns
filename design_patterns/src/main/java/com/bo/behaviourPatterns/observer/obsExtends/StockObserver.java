package com.bo.behaviourPatterns.observer.obsExtends;

import com.bo.behaviourPatterns.observer.Observer;
import com.bo.behaviourPatterns.observer.Subject;

/**
 * @author gpb
 * 具体的观察者 比如看股票的同事,看NBA球赛的同事
 */
public class StockObserver extends Observer {

    public StockObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭股票行情,继续工作");
    }
}
