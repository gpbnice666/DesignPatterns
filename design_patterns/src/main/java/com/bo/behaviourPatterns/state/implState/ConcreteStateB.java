package com.bo.behaviourPatterns.state.implState;

import com.bo.behaviourPatterns.state.Context;
import com.bo.behaviourPatterns.state.State;

/**
 * @author gpb
 * 具体的状态B
 */
public class ConcreteStateB extends State {
    @Override
    protected void handle(Context context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}
