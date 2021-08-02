package com.bo.structuralPattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gpb
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory {

    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), // 目标对象的加载器
                target.getClass().getInterfaces(),   // 目标对象实现接口的类型
                new InvocationHandler() {      // 事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务,事务级别是 不可重复读");
                        Object invoke = method.invoke(target, args);
                        System.out.println("结束事务,事务级别是 不可重复读");
                        return invoke;
                    }
                });
    }


}
