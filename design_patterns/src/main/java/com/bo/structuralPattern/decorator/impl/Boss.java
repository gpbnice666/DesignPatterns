package com.bo.structuralPattern.decorator.impl;

import com.bo.structuralPattern.decorator.Beverage;

/**
 * @author
 * 老板咖啡品种
 */
public class Boss implements Beverage {

    private String description = "选择了老板咖啡";


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getPrice() {
        return new Double(50);
    }
}
