package com.bo.behaviourPatterns.mediator;

import com.bo.behaviourPatterns.mediator.colleagueImpl.ConcreteColleague1;
import com.bo.behaviourPatterns.mediator.colleagueImpl.ConcreteColleague2;
import com.bo.behaviourPatterns.mediator.mediatorImpl.ConcreteMediator;

/**
 * @author gpb
 */
public class Client {

    public static void main(String[] args) {
        Mediator concreteMediator = new ConcreteMediator();
        Colleague c1,c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
    //    System.out.println(c1);
  //      System.out.println(c2);
//        System.out.println(concreteMediator);
        concreteMediator.register(c1);
        concreteMediator.register(c2);
        c1.send();
        System.out.println("******------*******");
      //  c2.send();
    }

}
/*
* 中介者模式
*       定义一个中介对象来封装一些列的对象之间的交互，使原有对象之间的耦合松散，且可以独立的改变他们之间的交互，中介者又叫做调停模式，它是迪米特法则的典型引用
*
* 优点
*       类之间各司其值，符号迪米特法则
*       降低了对象之间的耦合性，使得对象易于独立的服用
*       将对象间的一对多关联变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展
* 缺点：
*       中介者模式将原本都个对象的直接互相依赖变成了中介者和多个同事类的依赖关系，当同事类越多时，中介者就臃肿，变得复杂和难以维护
*
* 结构：
*       抽象中介者(Mediator):他是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法
*       具体中介者（MediatorImpl） 实现了中介者的接口，定义了一个List来管理同事对象，协调各个同事角色的交互，因此依赖同事角色
*       抽象同事类（Colleague）  定义了同事类的接口，保存了中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能
*       具体同事类（ColleagueImpl） 实现了抽象同事类，当需要与其他同事对象交互时，由中介者对象负责后续的交互
*
*
*应用场景
*       当对象之间在复杂的网状结构关系而导致依赖关系混乱且难以服用时
*       当想创建一个运行于多个类之间的对象，又不想生成的子类时
*
*
*扩展
*       不定义中介者接口，把具体中介者对象实现成为单例。
        同事对象不持有中介者，而是在需要的时候直接获取中介者对象并调用
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */
