package com.bo.behaviourPatterns.state.instance.threadStateImpl;

import com.bo.behaviourPatterns.state.instance.ThreadState;

/**
 * @author gpp
 * 具体状态类：死亡状态
 */
class Dead extends ThreadState {
    public Dead() {
        setStareName("死亡状态");
        System.out.println("当前线程处于：死亡状态.");
    }
}