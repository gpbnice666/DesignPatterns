package com.bo.structuralPattern.decorator;

import com.bo.structuralPattern.decorator.decExtends.Milk;
import com.bo.structuralPattern.decorator.decExtends.Mocha;
import com.bo.structuralPattern.decorator.impl.Boss;

import java.io.OutputStream;

/**
 * @author gpb
 * 客户端
 *
 * 概念
 *        装饰者又名包装者(Wrapper) 装饰模式一对客户端透明的方式扩展对象,是继承关系的以替代方案;
 *        但是纯粹的装饰模式很难找到,大多数的装饰模式的实现都是半透明的,而不是完全透明的,总言之,允许装饰模式改变接口,增加新的方法
 *     半透明的装饰模式是介于装饰模式和适配器模式之间,适配器模式的用意是改变所考虑的类的接口,
 *     也可以通过改写一个或几个方法,或增加新的方法来增强或改变所考虑的类的功能;
 *
 *     大多数的装饰模式实际上是半透明的装饰模式，这样的装饰模式也称做半装饰、半适配器模式
 * 针对的问题
 *      动态的给一个对象添加一些额外的职责,就增加功能来说,Decorator模式相比生成子类更为灵活,不改变接口的前提下 增强所考虑的类的性能
 * 合适使用
 *         1) 需要扩展一个类的功能,或给一个类增加附加责任
 *         2) 需要动态的给一个对象增加功能,这些功能可以在同态的撤销
 *         3) 需要增加一些基本功能的排列组合而产生非常大量功能,从而使继承变得不显示
 * 角色组成
 *      抽象构件(Component)角色：给出一个抽象接口,一规范准备收附加责任的对象
 *      具体构件(ComponentImpl):定义一个将要接受附加责任的类
 *      装饰角色(Decorator)：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口
 *      具体装饰角色(ConcreteDecorator)：负责给构件对象“贴上”附加的责任
 * 举例说明
 *        咖啡是一种饮料，咖啡的本质是咖啡豆+水磨出来的。咖啡店现在要卖各种口味的咖啡，如果不使用装饰模式，
 *        那么在销售系统中，各种不一样的咖啡都要产生一个类，如果有4中咖啡豆，5种口味，那么将要产生至少20个类（不包括混合口味），
 *        非常麻烦。使用了装饰模式，只需要11个类即可生产任意口味咖啡（包括混合口味）。
 * 装饰者优点
 *       继承的有力补充，比继承灵活，不改变原有对象的情况下给一个对象扩展功能
 *       通过使用不同装饰类以及这些装饰类的排列组合，可以实现不同效果
 *       符合开闭原则
 * 装饰者缺点
 *       会出现更多的代码，更多的类，增加程序复杂性
 *       动态装饰时，多层装饰时会更复杂
 */
public class Client {
    public static void main(String[] args) {
        // 选择老板咖啡
        Beverage boss = new Boss();

        boss = new Mocha(boss);		//为咖啡加了摩卡
        boss = new Milk(boss);
        boss = new Mocha(boss);
        System.out.println(boss.getDescription()+"\n加了摩卡和牛奶的咖啡价格："+boss.getPrice());


        OutputStream stream;
    }
}
