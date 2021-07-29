package com.bo.structuralPattern.decorator.impl;

import com.bo.structuralPattern.decorator.Beverage;

/**
 * @author gpb
 * 星巴克咖啡品种
 */
public class Starbux implements Beverage {

    private String description = "选择了星巴克咖啡";

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return new Double(80);
    }
}
