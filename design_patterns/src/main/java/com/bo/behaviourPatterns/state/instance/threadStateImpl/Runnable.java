package com.bo.behaviourPatterns.state.instance.threadStateImpl;

import com.bo.behaviourPatterns.state.instance.ThreadContext;
import com.bo.behaviourPatterns.state.instance.ThreadState;

/**
 * @author gpp
 * 具体状态类：就绪状态
 */
public class  Runnable extends ThreadState {
    public Runnable() {
        setStareName("就绪状态");
        System.out.println("当前线程处于：就绪状态.");
    }
    public void getCPU(ThreadContext hj) {
        System.out.print("获得CPU时间-->");
        if (getStareName().equals("就绪状态")) {
            hj.setState(new Running());
        } else {
            System.out.println("当前线程不是就绪状态，不能获取CPU.");
        }
    }
}
