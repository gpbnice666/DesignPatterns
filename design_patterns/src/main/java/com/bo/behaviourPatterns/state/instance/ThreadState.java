package com.bo.behaviourPatterns.state.instance;

/**
 * @author gpb
 * 线程状态类
 */
public abstract class ThreadState {

    protected String stareName;

    public String getStareName() {
        return stareName;
    }

    public void setStareName(String stareName) {
        this.stareName = stareName;
    }
}
