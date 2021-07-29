package com.bo.structuralPattern.bridge;

import com.bo.structuralPattern.bridge.colorImpl.Red;
import com.bo.structuralPattern.bridge.shapeImpl.Rectangle;
import com.bo.structuralPattern.bridge.shapeImpl.Square;
import com.mysql.jdbc.Driver;


/**
 *  桥接模式适用于抽象化与实现化解耦,使得二者可以独立变化,这种类型的设计模式时结构性,他通过提供抽象化和实现之间的桥接结构,来实现二者的解耦
 *  这种模式涉及到一个作为桥接的接口,是的实体类的功能独立于接口实现类,这两种类型可被机构化变化儿互不影响
 *  案例：
 *      可以使用相同的抽象类方法,但是不同的桥接实现类,来画出不同颜色的图形
 *  主要解决
 *         在有多种可能变化的情况下,用继承会造成类爆炸问题,扩展起来不灵活
 *  何时使用
 *         实现系统可能有斗个角度分类,每一种角度可能变化
 *  如何解决
 *          把这种多角度分类分离出来,让他们独立变化,减少它们之间的耦合度
 *  关键代码
 *          抽象类依赖实现类
 *  应用实例
 *          比如画图  你可以把颜色和图形独立出来
 *              你可以组成 红色的正方形 绿色的正方形
 *          在图形类 依赖 颜色类
 *          通过什么颜色去绘画什么类型的图形
 *  优点：
 *         抽象和实现分离,优秀的扩展能力,实现细节对客户透明
 *  缺点
 *         桥接模式的引入会增加系统的理解与设计难度,由于聚合关联关系建立在抽象曾,要求开发着对抽象设计与编程
 * 使用场景
 *      如果一个系统需要在构件的抽象角色和具体角色之间增加的更加灵活,避免在两个层次之间建立静态和继承关系,通过
 *      桥接模式可以他们在抽象层建立一个关联关系
 *      对于那些不希望使用继承或因为多层次导致系统类的个数急剧增加的系统,桥接模式尤为使用
 *      一个类存在连个独立变化的维度,且这两个维度都需要进行扩展
 * 注意事项
 *      对于两个独立变化的维度，使用桥接模式再适合不过了
 */
public class Client {
    public static void main(String[] args) {
        //白色
        Color white = new Red();
        //正方形
        Shape square = new Square();
        //白色的正方形
        square.setColor(white);
        square.draw();
        
        //长方形
        Shape rectange = new Rectangle();
        rectange.setColor(white);
        rectange.draw();

        System.out.println("--------------JDBC源码-----------------");
        Driver driver;
    }
}