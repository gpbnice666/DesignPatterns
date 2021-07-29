package com.bo.structuralPattern.decorator.decExtends;

import com.bo.structuralPattern.decorator.Beverage;
import com.bo.structuralPattern.decorator.Decorator;

/**
 * @author gpb
 * 具体装饰类
 */
public class Mocha extends Decorator {
    private String description = "加了摩卡！";

    private Beverage beverage = null;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription()+"\n"+description;
    }
    public Double getPrice() {
        return beverage.getPrice() + 30;    //30表示摩卡的价格
    }
}
