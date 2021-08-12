package com.bo.behaviourPatterns.state.instance.threadStateImpl;

import com.bo.behaviourPatterns.state.instance.ThreadContext;
import com.bo.behaviourPatterns.state.instance.ThreadState;


/**
 * @author gpp
 * 具体状态类：阻塞状态
 */
public class Blocked extends ThreadState {
    public Blocked() {
        setStareName("阻塞状态");
        System.out.println("当前线程处于：阻塞状态.");
    }
    public void resume(ThreadContext hj) {
        System.out.print("调用resume()方法-->");
        if (getStareName().equals("阻塞状态")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}
