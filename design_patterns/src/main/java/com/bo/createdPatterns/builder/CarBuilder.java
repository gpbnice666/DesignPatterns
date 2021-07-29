package com.bo.createdPatterns.builder;

import java.util.ArrayList;


//抽象建造者 建造什么类型的车子
public abstract class CarBuilder {
    protected abstract void setSequence(ArrayList<String> sequence);

    protected abstract CarModel getCarModel();
}
