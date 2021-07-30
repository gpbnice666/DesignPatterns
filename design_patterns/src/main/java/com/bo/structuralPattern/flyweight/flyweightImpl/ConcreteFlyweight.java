package com.bo.structuralPattern.flyweight.flyweightImpl;


import com.bo.structuralPattern.flyweight.Flyweight;

/**
 * @author gpb
 * 具体享元角色类
 * 具体享元角色类ConcreteFlyweight有一个内蕴状态,在本例中一个Character类型的intrinsicState属性代表,他的值应当在享元对象
 * 被创建是赋予,所有的内蕴状态在创建之后,是不会在改变,如果一个享元对象有外蕴状态的话,所有的外部状态都必须存储在客户端
 * 在使用享元对象时,在由客户端转入享元对象,这里只有个外蕴状态,operation()方法的参数就是由外部传入的外蕴状态
 */
public class ConcreteFlyweight implements Flyweight {
    private  Character intrinsicState = null;
    /**
     * 构造函数，内蕴状态作为参数传入
     * @param state
     */
    public ConcreteFlyweight(Character state){
        this.intrinsicState = state;
    }

    /**
     * 外部状态作为参数传入方法中,改变方法的行为
     * 但是并不改变对象的内蕴状态
     * @param state
     */
    @Override
    public void operation(String state) {
        System.out.println("Intrinsic State = "+this.intrinsicState);
        System.out.println("Extrinsic State = " + state);
    }
}
