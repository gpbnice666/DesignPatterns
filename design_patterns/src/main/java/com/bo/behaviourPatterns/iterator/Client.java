package com.bo.behaviourPatterns.iterator;

import com.bo.behaviourPatterns.iterator.aggregateImpl.ConcreteAggregate;

/**
 * @author gpb
 */
public class Client {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.print("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.print(ob.toString() + "\t");
        }
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString());
    }
}
/*
* 迭代器：
*       提供了一个对象来顺序访问聚合对象中的一些列数据，而不暴露聚合对象的内部表示
* 优点
*       访问一个聚合对象的内容而无须他的内部表示
*       遍历任务交给迭代器完成，简化了聚合类
*       支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持的遍历
*       增加新的聚合类和迭代器类都很方便，无须修改原来代码
*      封装性良好，为了遍历不同的聚合结合机构提供统一的接口
* 缺点：
*       增加了类的个数，这在一定程度上增加了系统的复杂性
*
* 迭代器模式是通过将聚合对象的遍历行为分离出来抽象成迭代器类来实现的，其目的是在不暴露聚合对象的内部结构的情况下，让外部代码透明的访问聚合的内部数据
*  现象我们来分析基本结构于实现方法
*
* 结构
，*   抽象聚合(Aggregate)：定义存储、添加、删除聚合对象以及创建迭代器对象的接口
*     具体聚合（AggregateImpl） 实现抽象聚合类，返回一个具体迭代器的实例。
*   抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
*  具体迭代器（IteratorImpl）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。
* 模式的应用场景
        当需要为聚合对象提供多种遍历方式时。
        当需要为遍历不同的聚合结构提供一个统一的接口时。
        当访问一个聚合对象的内容而无须暴露其内部细节的表示时。
*
* 扩展
*   迭代器模式常常与组合模式结合起来使用，在对组合模式中的容器构件进行访问时，经常将迭代器潜藏在组合模式的容器构成类中。
*   当然，也可以构造一个外部迭代器来对容器构件进行访问，其
* */

