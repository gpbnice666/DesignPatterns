package com.bo.behaviourPatterns.command.instance;

import com.bo.behaviourPatterns.command.instance.commandImpl.ConcreteCommand1;
import com.bo.behaviourPatterns.command.instance.commandImpl.ConcreteCommand2;

/**
 * @author gpb
 * 在软件开发中，有时将命令模式与组合模式联合使用，这就构成了宏命令模式，
 * 也叫组合命令模式。宏命令包含了一组命令，它充当了具体命令与调用者的双重角色，执行它时将递归调用它所包含的所有命令
 */
public class CompositeCommandPattern {
    public static void main(String[] args) {
        AbstractCommand cmd1 = new ConcreteCommand1();
        AbstractCommand cmd2 = new ConcreteCommand2();
        CompositeInvoker ir = new CompositeInvoker();
        ir.add(cmd1);
        ir.add(cmd2);
        System.out.println("客户访问调用者的execute()方法...");
        ir.execute();
    }
}