package com.bo.behaviourPatterns.chainOfResponsibility;

import com.bo.behaviourPatterns.chainOfResponsibility.handler.AbstractLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.DeptManagerLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.DirectLeaderLeaveHandler;
import com.bo.behaviourPatterns.chainOfResponsibility.handler.impl.GManagerLeaveHandler;

/**
 * @author gpb
 */
public class Client {

    public static void main(String[] args) {
        LeaveRequest request = LeaveRequest.builder().leaveDays(3).name("小明").build();

        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        AbstractLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        AbstractLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);
    }

}
/*
*   责任链模式(职责链模式)：
*           为了避免请求发送者与多个请求处理者耦合在一起,于是将所以请求的处理者通过前一对象 记住其下一个对象的引用而连城的一条链
*           当有请求发生时，可将请求沿着这条链传递，直到有对象处理为止
*   在责任链模式中，客户只需要将请求发送到责任链上即可，无需关心请求的处理细节和请求的传递过程，请求会自动进行传递，所以责任链将请求的处理者解耦
*
* 优点：
*       降低了对象之间的耦合度，该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无需拥有对方的明确信息
*       增强了系统的可扩展性，可以根据需要增加请求处理类。
*       增强了给对象指派职责的灵活性，当工作流程发送变化，可以动态的改变链内的成员变量或调动它们的次序，也可动态的新增或者删除责任
*       责任链简化了对象之间的链接，每个对象只需保持一个指向后需者的引用，不需保持其他所以处理者的引用，这避免了使用从多的  if  else
*       责任分担，每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象来完成，明确各类责任范围，符合类的单一职责
* 缺点：
*       不能保证每个请求一定被处理，由于一个请求没有明确的接受者，所以不能保证他一定会被处理，该请求可能一致链的末端都得不到处理
*       对于较长的职责链，请求的处理可能涉及多个处理对象，系统性能将收到一定的影响
*       职责链建立的合理性要客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，可能会造成循环调用
*
*结构：
*       抽象处理者(Handler)：顶一个处理请求的接口，包韩抽象处理方法和下一个链接
*       具体处理者(HandderImpl) 实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
*       客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
*
* 责任链模式的本质是解耦请求与处理，让请求在处理链中能进行传递与被处理；理解责任链模式应当理解其模式，
* 而不是其具体实现。责任链模式的独到之处是将其节点处理者组合成了链式结构，并允许节点自身决定是否进行请求处理或转发，相当于让请求流动起来。
*
*
* 模式的应用场景
        前边已经讲述了关于责任链模式的结构与特点，下面介绍其应用场景，责任链模式通常在以下几种情况使用。
        多个对象可以处理一个请求，但具体由哪个对象处理该请求在运行时自动确定。
        可动态指定一组对象处理请求，或添加新的处理者。
        需要在不明确指定请求处理者的情况下，向多个处理者中的一个提交请求。
    模式的扩展
        职责链模式存在以下两种情况。
        纯的职责链模式：一个请求必须被某一个处理者对象所接收，且一个具体处理者对某个请求的处理只能采用以下两种行为之一：自己处理（承担责任）；把责任推给下家处理。
        不纯的职责链模式：允许出现某一个具体处理者对象在承担了请求的一部分责任后又将剩余的责任传给下家的情况，且一个请求可以最终不被任何接收端对象所接收。
*
* */