package com.bo.behaviourPatterns.command;

/**
 * 调用者
 * @author gpb
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command){
        this.command = command;
    }

    public void call(){
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}
