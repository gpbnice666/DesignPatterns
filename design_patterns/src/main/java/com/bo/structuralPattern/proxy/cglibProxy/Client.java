package com.bo.structuralPattern.proxy.cglibProxy;


import com.bo.structuralPattern.proxy.cglibProxy.dao.UserDao;

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
 *
 *   静态代理和动态代理模式都是需要实现接口的目标对象,但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,
 *   这个时候可以使用目标对象子类的
 *   方法类实现代理,这种方法就叫做：Cglib代理
 *   Cglib代理,也叫做子类代理,他是在内存中构建一个子类对象从实现对目标对象功能增强的扩展
 *      JDK动态代理有个限制,就是使用动态代理的对象必须实现一个接口或多个接口,如果想代理没有实现接口的类,可以使用Cglib实现
 *      Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展Java类与实现Java接口，他广泛的被许多AOP框架使用,比如 String AOP,和synaop，为他们提供方法的interception（拦截）
 *      Cglib包的底层通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类，不鼓励直接使用ASM,因为他要求你必须对JVM结构包括class文件的格式和指令集都很熟悉
 *
 *   实现方法：
 *      需要引入cglib的jar包或者依赖,但是Spring的核心包已经包括Cglib功能,所以直接引入spring依赖或jar
 *      引入功能包后,就可以在内存中动态构件子类
 *      代理的类不能被final修饰,否则会报错,因为他是在内存中动态生成目标类的子类,所以不能使用final
 *      目标对象的方法如果为final,static,就不被拦截,即不会执行目标对象额外的业务方法
 *    在Spring的AOP编程中:
 *        如果加入容器的目标对象有实现接口,用JDK代理
 *        如果目标对象没有实现接口,用Cglib代理
 */
public class Client {

    public static void main(String[] args) {
        // 目标对象
        UserDao userDao = new UserDao();
        // 代理对象
        UserDao proxyInstance = (UserDao)new ProxyFactory(userDao).getProxyInstance();

        proxyInstance.save();

        proxyInstance.query(1,"10");

        proxyInstance.update(2);

    }

}
