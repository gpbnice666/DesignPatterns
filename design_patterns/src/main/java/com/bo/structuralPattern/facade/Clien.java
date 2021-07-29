package com.bo.structuralPattern.facade;

import com.bo.structuralPattern.facade.pojo.Man;
import com.bo.structuralPattern.facade.pojo.TeaLeaf;
import com.bo.structuralPattern.facade.pojo.TeaWater;
import com.bo.structuralPattern.facade.pojo.Water;
import com.bo.structuralPattern.facade.service.KettleService;
import com.bo.structuralPattern.facade.service.TeaSetService;
import org.springframework.jdbc.support.JdbcUtils;


/**
 * 外观模式
 *      外观模式是一种使用频繁非常高的结构型设计模式,它通过引入外观角色来简化客户端与子系统之间的交互,为复杂的子系统调用提供
 *      一个统一的接口,降低了子系统与客户端的耦合度,且客户调用非常方便
 *      外观模式又称为门面模式,它是一种对象结构模型,外观模式是迪米特法则的具体实现,通过引入一个新的角色可以降低原有的系统的复杂度
 *      同时降低客户类与子系统的耦合度
 *
 * 主要角色
 *       Facade（外观角色）：在客户端可以调用它的方法，在外观角色中可以知道相关的（一个或者多个）子系统的功能和责任；
 *       在正常情况下，它将所有从客户端发来的请求委派到相应的子系统去，传递给相应的子系统对象处理。
 *
 *       SubSystem（子系统角色）：在软件系统中可以有一个或者多个子系统角色，
 *       每一个子系统可以不是一个单独的类，而是一个类的集合，它实现子系统的功能；每一个子系统都可以被客户端直接调用，
 *       或者被外观角色调用，它处理由外观类传过来的请求；子系统并不知道外观的存在，对于子系统而言，外观角色仅仅是另外一个客户端而已
 *
 *      外观模式的目的不是给予子系统添加新的功能接口，而是为了让外部减少与子系统内多个模块的交互，松散耦合，从而让外部能够更简单地使用子系统。
 *
 *  本质
 *      封装交互,简化调用
 *  优点
 *     它对客户端屏蔽,了子系统的组件,减少了客户端,所需处理的对象数目,并使的子系统使用起来更加容易,通过引入外观模式,客户端代买将变得很简单
 *     与之关联的对象也很少
 *     它实现了子系统与客户端之间的松耦合关系,这使得子系统的变化不会影响到调用它的客户端,只需要调整外观类即可
 *     一个子系统的修改对其他子系统没有任何影响,而且子系统内部变化也不会影响到外观对象
 *  缺点
 *      不能很好的限制客户端直接使用子系统,如果对客户端访问了子系统类做太多的限制则减少了可变性和灵活性
 *      如果设计不当,增加新的子系统可能需要修改 外观类的源码,违背了开闭原则
 *  使用场景
 *      当要为访问一系列复杂的子系统提供的一个简单入口是可以用使用到外观模式、
 *      客户端程序与多个子系统之间存在很大的依赖性。引入外观类可以将子系统与客户端解耦,从而提高了子系统的独立性和可移植性
 *      在层次化结构中,可以使用外观模式定义系统中每一层的入口，层与层之间不直接产生联系,而通过外观类建立联系,降低层之间的耦合度
 */
public class Clien {
    public static void main(String[] args) {
        Man zhangsan = new Man("张三");
        KettleService kettleService1 = new KettleService();
        TeaSetService teasetService1 = new TeaSetService();
        Water water1 = new Water();
        TeaLeaf teaLeaf1 = new TeaLeaf("西湖龙井");
        kettleService1.waterBurning(zhangsan.getName(), water1, 4);
        TeaWater teawater1 = teasetService1.makeTeaWater(zhangsan.getName(), water1, teaLeaf1);
        zhangsan.drink(teawater1);
        System.out.println();

        Man lisi = new Man("李四");
        KettleService kettleService2 = new KettleService();
        TeaSetService teasetService2 = new TeaSetService();
        Water water2 = new Water(10, 15);
        TeaLeaf teaLeaf2 = new TeaLeaf("碧螺春");
        kettleService2.waterBurning(lisi.getName(), water2, 4);
        TeaWater teawater2 = teasetService2.makeTeaWater(lisi.getName(), water2, teaLeaf2);
        lisi.drink(teawater2);
        System.out.println("*********************外观模式 到茶馆喝茶***********************");
        Man man = new Man("张三");
        man.drink(new TeaHouseFacade("大威天龙").makeTea(1));

        Man man2 = new Man("李四");
        man2.drink(new TeaHouseFacade("卧槽,搞偷袭").makeTea(3));

        JdbcUtils jdbcUtils;
    }
}
