package com.bo.behaviourPatterns.command.instance;

import java.util.ArrayList;

/**
 * @author gpb
 * 调用者
 */
public class CompositeInvoker implements AbstractCommand{
    private ArrayList<AbstractCommand> children = new ArrayList<AbstractCommand>();

    public void add(AbstractCommand c) {
        children.add(c);
    }
    public void remove(AbstractCommand c) {
        children.remove(c);
    }
    public AbstractCommand getChild(int i) {
        return children.get(i);
    }

    @Override
    public void execute() {
        for (Object obj : children) {
            ((AbstractCommand) obj).execute();
        }
    }
}
