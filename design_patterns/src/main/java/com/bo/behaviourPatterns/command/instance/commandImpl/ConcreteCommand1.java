package com.bo.behaviourPatterns.command.instance.commandImpl;

import com.bo.behaviourPatterns.command.instance.AbstractCommand;
import com.bo.behaviourPatterns.command.instance.CompositeReceiver;

/**
 * @author gpb
 * 树叶构件: 具体命令1
 */
public class ConcreteCommand1 implements AbstractCommand {
    private CompositeReceiver receiver;
    public ConcreteCommand1() {
        receiver = new CompositeReceiver();
    }
    public void execute() {
        receiver.action1();
    }
}