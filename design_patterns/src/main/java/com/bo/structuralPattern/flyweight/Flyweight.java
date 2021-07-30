package com.bo.structuralPattern.flyweight;


/**
 * @author gpb
 * 抽象享元模式角色类
 */
public interface Flyweight {
    // 一个示意行方法,参数state是外蕴状态
    public void operation(String state);
}
