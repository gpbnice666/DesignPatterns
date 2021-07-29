package com.bo.structuralPattern.decorator.impl;

import com.bo.structuralPattern.decorator.Beverage;

/**
 * @author gpb
 * 福爵咖啡品种
 */
public class Folgers implements Beverage {
    private String description = "选择了福爵咖啡品种";


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return new Double(55);
    }
}
