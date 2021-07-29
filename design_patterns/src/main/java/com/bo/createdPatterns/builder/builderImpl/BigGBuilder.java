package com.bo.createdPatterns.builder.builderImpl;

import com.bo.createdPatterns.builder.CarBuilder;
import com.bo.createdPatterns.builder.CarModel;
import com.bo.createdPatterns.builder.modelImpl.BigGModel;

import java.util.ArrayList;

//具体的建造该品牌下什么类型的车子
public class BigGBuilder extends CarBuilder {

    private BigGModel bigGModel = new BigGModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bigGModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bigGModel;
    }
}
