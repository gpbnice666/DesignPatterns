package com.bo.behaviourPatterns.observer;

import com.bo.behaviourPatterns.observer.obsExtends.NBAObserver;
import com.bo.behaviourPatterns.observer.obsExtends.StockObserver;
import com.bo.behaviourPatterns.observer.subject.Boss;
import com.bo.behaviourPatterns.observer.subject.Secretary;

/**
 *  @author gpb
 *  观察者一般可以看做是第三者,比如在学校上自习的时候,大家肯定都有过交头接耳,各自玩耍的经历,或者大家上班,划水,有人在放哨,通知老板来没来,
 *   观察者模式(Observer),又称为发布-订阅模式(Publish/Subscribe),定义对象间一种一对多的依赖关系,使得每当一个对象改变状态,则所用依赖与它的对象
 *   都会得到通知并自动更新
 *
 *  其中，Subject类是主题,他把所以的对观察者的引用文件存在一个聚集里,每个主题都可以有任何数量的观察者,抽象主题提供了一个接口,可以增加和删除观察者对象
 *   Observer类是抽象观察者,为所以具体观察者定义一个接口,在得到主题的通知时更新自己,
 *   Secretary类是一个具体的主题,将有关状态存入具体观察者对象,在具体主题内部状态可以改变时,给所以的登记过的观察者发送通知
 *   StockObserver类是具体的观察者,实现抽象观察者的角色所以要求的接口，以便使得本身的状态与主题相协同
 *
 *   合适使用
 *        一个对象状态改变,所以的依赖对象都将得到通知
 *   优点
 *        观察者和被观察者是抽象耦合的
 *        建立了一套触发机制
 *   缺点
 *        如果一个被观察者对象有更多的直接和间接的观察者的话,将所以的观察者都通知到会花费很多时间
 *        如果观察者和观察目标间有循环依赖，可能导致系统崩溃
 *       没有相应的机制让观察者知道所以观察的目标是怎末发生变化的
 *   使用场景
 *       关联行为场景
 *       实际多级出发场景
 *        跨系统的消息换场景 如消息队列的处理机制
 *   应用实例
 *        手机丢了，委托别人给其他人发消息通知
 *       通知老师/老板来了
 *        拍卖，拍卖师观察最高标价，然后通知给其它竞价者竞价
 *       在一个目录下建立一个文件，会同时通知目录管理器增加目录，并通知磁盘减少空间，文件是被观察者，目录管理器和磁盘管理器是观察者
 *       猫叫了一声，吓着了老鼠，也惊到了主人，猫是被观察者，老鼠和人是观察者
 *   注意事项
 *         避免循环引用
 *         如果顺序执行，某一观察者错导致系统卡壳，一般采用异步方式
 *  当一个对象的改变需要同时改变其他对象,并且他不知道具体有多少对象持有改变的时候,应该考虑观察者模式
 *  而使用观察者模式的动机在于：将一个系统分割成一些列相互协作的类有一个很不好的 副作用,就是需要维护相关对象间的一致性,
 *  我们不希望为了维持一致性而使各类紧密耦合,这样会个维护、扩展和重重用代来不变,观察者模式所作的共奏就是在解耦合
 *
 *
 */
public class Client {
    public static void main(String[] args) {

        // 通知者  前台
        Subject secretary = new Secretary();
        // 通知者 老板
        Subject boss = new Boss();
        // 观察者 股票
        Observer stockObserver = new StockObserver("admi", secretary);
        // 观察者 NBA
        Observer nbaObserver = new NBAObserver("tom", boss);
        // 前台通知
        secretary.attach(stockObserver);
        boss.attach(nbaObserver);
        // 状态
        secretary.setAction("老板来了");
        boss.setAction("咳咳,干嘛呢");
        // 发起通知
        secretary.notifyObservers();
        boss.notifyObservers();
    }
}
