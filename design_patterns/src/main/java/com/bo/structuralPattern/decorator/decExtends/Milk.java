package com.bo.structuralPattern.decorator.decExtends;

import com.bo.structuralPattern.decorator.Beverage;
import com.bo.structuralPattern.decorator.Decorator;

/**
 * @author gpb
 * 具体装饰类
 */
public class Milk extends Decorator {
    private String description = "加了牛奶！";

    private Beverage beverage = null;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription()+"\n"+description;
    }
    public Double getPrice(){
        return beverage.getPrice()+20;	//20表示牛奶的价格
    }

}
