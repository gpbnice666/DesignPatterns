package com.bo.createdPatterns.builder;


import com.bo.createdPatterns.builder.builderImpl.BMWBuilder;
import com.bo.createdPatterns.builder.builderImpl.BigGBuilder;

import java.util.ArrayList;

//赋值生成具体什么类型车子 导演类 组织类型
public class Director {

    private ArrayList<String> sequence = new ArrayList<>();

    private BigGBuilder bigGBuilder = new BigGBuilder();

    private BMWBuilder bmwBuilder = new BMWBuilder();


    public CarModel getBigGModel(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bigGBuilder.setSequence(this.sequence);
        return this.bigGBuilder.getCarModel();
    }

    public CarModel getBMWBuilder(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return this.bmwBuilder.getCarModel();
    }

}
