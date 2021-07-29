package com.bo.createdPatterns.singletion;


/**
 * 饿汉式
 *
 * 在静态代码块中创建单例对象
 * 是否 Lazy 初始化：否
 *
 * 是否多线程安全：是
 *
 * 实现难度：易
 *
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 这种方式和静态常量汉饿式方式类似，只不过将类实例化的过程放在了静态代码块中，
 * 也是在类装载的时候，
 * 就执行静态代码块中的代码，初始化类的实例。优缺点和静态常量汉饿式一样
 */
public class SingleObject4 {

    private static SingleObject4 instance;

    static {
        instance = new SingleObject4();
    }

    public static SingleObject4 getInstance(){
        return instance;
    }

    //构造方法 改成私有化 private
    private SingleObject4(){}


}
