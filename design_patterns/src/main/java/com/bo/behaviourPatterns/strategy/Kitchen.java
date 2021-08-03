package com.bo.behaviourPatterns.strategy;

public class Kitchen {
    private CrabCooking strategy;    //抽象策略
    public void setStrategy(CrabCooking strategy) {
        this.strategy = strategy;
    }
    public CrabCooking getStrategy() {
        return strategy;
    }
    public void CookingMethod() {
        strategy.CookingMethod();    //做菜
    }
}
