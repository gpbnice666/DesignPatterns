package com.bo.behaviourPatterns.state.instance.threadStateImpl;

import com.bo.behaviourPatterns.state.instance.ThreadContext;
import com.bo.behaviourPatterns.state.instance.ThreadState;

/**
 * @author gpp
 * 具体状态类：运行状态
 */
public class Running extends ThreadState {
    public Running() {
        setStareName("运行状态");
        System.out.println("当前线程处于：运行状态.");
    }
    public void suspend(ThreadContext hj) {
        System.out.print("调用suspend()方法-->");
        if (getStareName().equals("运行状态")) {
            hj.setState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }
    public void stop(ThreadContext hj) {
        System.out.print("调用stop()方法-->");
        if (getStareName().equals("运行状态")) {
            hj.setState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}