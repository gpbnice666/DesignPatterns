package com.bo.behaviourPatterns.strategy;

import com.bo.behaviourPatterns.strategy.impl.BraisedCrabs;
import com.bo.behaviourPatterns.strategy.impl.SteamedCrabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author gpb
 * 策略模式
 *          该模式定义了一些列算法,并将每个算法封装起来,是他们可以变化不会影响使用算法的客户,策略模式属于行为模式
 *          通过对算法发的该井封装,吧使用算法的责任和算法的实现分割开来,并委派给不同的对象这些算法进行管理
 *  优点
 *      多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句，如 if...else 语句、switch...case 语句。
        策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
        策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
        策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
        策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。
    缺点
        客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。
        策略模式造成很多的策略类，增加维护难度。
策略模式的结构与实现
            策略模式是准备一组算法，并将这组算法封装到一系列的策略类里面，
            作为一个抽象策略类的子类。策略模式的重心不是如何实现算法，而是如何组织这些算法，
           从而让程序结构更加灵活，具有更好的维护性和扩展性，现在我们来分析其基本结构和实现方法。
1. 模式的结构
策略模式的主要角色如下。
       抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
      具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
     环境（Context）类：持有一个策略类的引用，最终给客户端调用。
 */


public class CrabCookingStrategy implements ItemListener {

    private JFrame f;
    private JRadioButton qz,hs;
    private JPanel CenterJP,SouthJP;
    private Kitchen cf; // 厨房
    private CrabCooking qzx,hsx;

    CrabCookingStrategy() {
        f = new JFrame("策略模式在大闸蟹做菜中的应用");
        f.setBounds(100, 100, 500, 400);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SouthJP = new JPanel();
        CenterJP = new JPanel();
        f.add("South", SouthJP);
        f.add("Center", CenterJP);
        qz = new JRadioButton("清蒸大闸蟹");
        hs = new JRadioButton("红烧大闸蟹");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        //---------------------------------
        cf = new Kitchen();    //厨房
        qzx = new SteamedCrabs();    //清蒸大闸蟹类
        hsx = new BraisedCrabs();    //红烧大闸蟹类
    }
    public void itemStateChanged(ItemEvent e) {
        JRadioButton jc = (JRadioButton) e.getSource();
        if (jc == qz) {
            cf.setStrategy(qzx);
            cf.CookingMethod(); //清蒸
        } else if (jc == hs) {
            cf.setStrategy(hsx);
            cf.CookingMethod(); //红烧
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component) cf.getStrategy());
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new CrabCookingStrategy();
    }
}
