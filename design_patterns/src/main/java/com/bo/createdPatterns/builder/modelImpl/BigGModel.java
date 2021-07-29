package com.bo.createdPatterns.builder.modelImpl;

import com.bo.createdPatterns.builder.CarModel;

public class BigGModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("大G启动");
    }

    @Override
    protected void stop() {
        System.out.println("大Gstop");
    }

    @Override
    protected void alarm() {
        System.out.println("大G滴滴");
    }

    @Override
    protected void engineBoom() {
        System.out.println("大G 嗡嗡的发动机声");
    }
}
