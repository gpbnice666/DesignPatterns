package com.bo.createdPatterns.prototype;


/**
 *  对象拷贝是构造函数不会执行,
 *  原理：
 *      Object类的clone方法的原理是从内存中(具体说就是堆栈)
 *      以二进制流的方式进行拷贝,重新分配一个内存块,那构造函数没有被执行也是非常正常的
 * 浅拷贝
 *      是应为Java做了一个偷懒的拷贝动作,Object类提供的方法clone()只是拷贝本对象
 *      其队形的内部的数组,引用对象等都不拷贝,还是只想原生对象的内部元素的地址成为浅拷贝
 *      两对象共享一个私有变量，是非常不安全的，,但是对String类型,Java就希望你把特认为是基本类型
 *      他是没有clone方法的，处理机制也比较特殊,通过字符串池(stringpool)在需要的时候才在内存中
 *      创行的字符串
 *深拷贝
 *      就是重新创建一个对象,地址是不一样的
 *      方式
 *          序列化
 *          clone方法进行赋值
 */
public class Client {
    public static void main(String[] args)  {
        Car car = new Car("大牛", 100000000, 600,new Author("小米","男",16));
        System.out.println("...............................................");
        Car clone = car.carClone();
        Car clone1 = car.clone();
        clone.getAuthor().setName("55555");
        System.out.println("原生对象"+car);
        System.out.println("序列化"+clone);
        System.out.println("clone"+clone1);
        System.out.println(car.getAuthor().getName());
        System.out.println(clone.getAuthor().getName());
        System.out.println(clone1.getAuthor().getName());
        System.out.println(car==clone);
        System.out.println(car==clone1);
        System.out.println(car.hashCode());
        System.out.println(clone.hashCode());
        System.out.println(clone1.hashCode());
    }
}
