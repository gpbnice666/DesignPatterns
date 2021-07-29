package com.bo.structuralPattern.decorator;

/**
 * @author gpb
 * 装饰类
 */
public class Decorator implements Beverage {

    private String description = "我只是装饰器,不知道具体描述";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return new Double(0);      //价钱由子类具体实现
    }
}
