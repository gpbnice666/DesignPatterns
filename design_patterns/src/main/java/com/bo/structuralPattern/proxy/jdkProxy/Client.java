package com.bo.structuralPattern.proxy.jdkProxy;


import com.bo.structuralPattern.proxy.jdkProxy.dao.IUserDao;
import com.bo.structuralPattern.proxy.jdkProxy.dao.impl.UserDao;
import com.bo.structuralPattern.proxy.staticProxy.UserDaoProxy;

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
 * 动态代理
 *      特点
 *          代理对象,不需要实现接口
 *          代理对象的生成,是利用JDK的API,动态的在内存中构造代理对象(需要我们指定创建代理对象/目标对象的实现的接口类型)
 *          动态代理也叫：JDK代理,接口代理
 * JDK中生成代理对象的API
 *      代理类所在包: java.lang.reflect.Proxy
 * JDK实现代理需要使用newProxyInstance方法,但是该方法需要接受三参数
 *  static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
 *  ClassLoader loader 指定当前目标对象使用类的jiazq,获取加载器的方法是固定的
 *  Class<?> interfaces 目标对象实现的接口类型，使用泛型方式确定类型
 *  InvocationHandler h 事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前目标对象的方法参数传入
 *
 *  总结
 *      代理对象不需要实现接口,但是目标对象一定要实现接口,否不能用动态代理
 *
 */
public class Client {

    public static void main(String[] args) {
        IUserDao target = new UserDao();
        IUserDao instance = (IUserDao)new ProxyFactory(target).getProxyInstance();
        instance.save();
    }

}
