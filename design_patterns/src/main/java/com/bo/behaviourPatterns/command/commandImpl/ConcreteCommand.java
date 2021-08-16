package com.bo.behaviourPatterns.command.commandImpl;

import com.bo.behaviourPatterns.command.Command;
import com.bo.behaviourPatterns.command.Receiver;

/**
 * @author gpb
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;


    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
