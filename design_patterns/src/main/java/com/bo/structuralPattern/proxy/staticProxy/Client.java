package com.bo.structuralPattern.proxy.staticProxy;


import com.bo.structuralPattern.proxy.staticProxy.dao.impl.UserDao;

/**
 * @author gpb
 * 测试
 *
 * 代理模式
 *      代理模式是一种设计模式,提供了对目标对象另外的一种访问方式,即通过对象访问目标对象,这样做的好处就是,可以在目标对象实现的
 *      基础上,增强额外的功能操作,即扩展目标对象的功能,这里使用到编程中的一个思想,不要随意去修改别人已经写好的代码或者方法,
 *
 *      如果需要修改,可以通过代理的方式去修改
 *
 *      代理模式的关键点：
 *          代理对象与目标对象,代理对象是对目标对象的扩展,并会调用,目标对象
 * 静态代理
 *      静态代理使用是,需要定义接口或者父类，被代理的对象与代理对象一起实现相同的接口或者继承相同父类
 * 静态代理总结
 *      可以做到在不修改目标对象的功能前体下,对目标功能扩展
 *  缺点
 *      因为代理对象需要与目标对象实现一样的接口或者父类,所以会有跟多个代理类，类太多,同时,一旦接口增加方法，
 *      目标对象和代理对象都需要委会
 *
 */
public class Client {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);

        userDaoProxy.save();
    }

}
