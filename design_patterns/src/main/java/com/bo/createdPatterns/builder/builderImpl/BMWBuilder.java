package com.bo.createdPatterns.builder.builderImpl;

import com.bo.createdPatterns.builder.CarBuilder;
import com.bo.createdPatterns.builder.CarModel;
import com.bo.createdPatterns.builder.modelImpl.BMWModel;

import java.util.ArrayList;

//具体的建造该品牌下什么类型的车子
public class BMWBuilder extends CarBuilder {
    private BMWModel bmwModel = new BMWModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }
}
