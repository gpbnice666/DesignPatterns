package com.bo.structuralPattern.composite;

import com.bo.structuralPattern.composite.absExtends.College;
import com.bo.structuralPattern.composite.absExtends.Deparment;
import com.bo.structuralPattern.composite.absExtends.University;

/**
 * Composite Pattern 组合模式
 *     组合模式 又称为部分整体模式,他创建对象组的树形结构,将对象组合成树状结构以表示整体-部分的层次关系
 *     组合模式一句树形结构来组合对象,用来表示以及整体层次
 *     这种类型的设计模式属于结构模式
 *     组合组合模式时的用户对单个对象合组合对象的访问具有一致性,即组合能给人客户一致的方式处理个别对象以及组合对象
 *
 * 简化客户端的操作,客户端只需要面对一致的对象而不用考虑整体部分或者叶子节点的问题
 * 具有较强的扩展性,当我们更该组合对象时候我们只需要调整内部层次关系,客户端不用做出任何改动
 * 方便创建出复杂的层次关系,客户端不用理会组合里面的 组成细节 容易添加节点或者叶子从而创建出复杂的树形结构
 * 需要遍历组织机构,或者处理的队形具有树形结构式,十分适合使用组合模式
 * 要求较高的抽象性,如果节点合叶子有很多的差异性的话,比如很多方法合属性都不一样 ,不适合使用组合模式
 */
public class Client {

    public static void main(String[] args) {

        //从大到小 学校
        OrganizationComponent university = new University("清华大学", "世界一流大学");

        //学院
        OrganizationComponent computerCollege = new College("计算机学院", "计算机学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程学院", "信息工程学院");

        //添加叶子节点 系
        computerCollege.add(new Deparment("软件工程","软件工程不错"));
        computerCollege.add(new Deparment("网路工程","网路工程不错"));
        computerCollege.add(new Deparment("计算机科学与技术","老牌技术"));

        //添加叶子节点
        infoEngineerCollege.add(new Deparment("信息工程","信息工程不好学"));
        infoEngineerCollege.add(new Deparment("通信工程","通信工程不错"));

        //将学院加入学校
        university.add(computerCollege);
        university.add(infoEngineerCollege);

        university.print();
    }
}
