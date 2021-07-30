package com.bo.structuralPattern.flyweight;


import com.bo.structuralPattern.flyweight.flyweightImpl.ConcreteFlyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gpb
 * 享元工厂角色类
 * 享元工厂角色类,必须指出是,客户端不可以直接将具体享元类实例化,而必须通过一个工厂对象,利用一个factory()方法得到享元对象
 * 一般而言,享元工厂对象在整个体系系统只有一个,因此也可以使用单例模式
 * 当客户端需要单纯享元对象的时候,需要调用享元工厂中的factory()方法,并传入所需要的单纯的享元对象的内蕴状态,由工厂方法产生所需要的享元对象
 */
public class FlyweightFactory {

    private Map<Character,Flyweight> flyweightMap = new HashMap<Character,Flyweight>();

    public Flyweight factory(Character character){
        Flyweight flyweight = flyweightMap.get(character);
        if(flyweight == null){
            flyweight = new ConcreteFlyweight(character);
            flyweightMap.put(character,flyweight);
        }
        return flyweight;
    }

    /**
     * 增加一个新的单纯享元对象添加到池中
     * @param key
     * @param flyweight
     */
    public void add(Character key,Flyweight flyweight){
        flyweightMap.put(key, flyweight);
    }


}
