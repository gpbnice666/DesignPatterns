package com.bo.behaviourPatterns.command.instance.commandImpl;

import com.bo.behaviourPatterns.command.instance.AbstractCommand;
import com.bo.behaviourPatterns.command.instance.CompositeReceiver;

/**
 * @author gpb
 * 树叶构件: 具体命令2
 */
public class ConcreteCommand2 implements AbstractCommand {
    private CompositeReceiver receiver;
    public ConcreteCommand2() {
        receiver = new CompositeReceiver();
    }
    public void execute() {
        receiver.action2();
    }
}