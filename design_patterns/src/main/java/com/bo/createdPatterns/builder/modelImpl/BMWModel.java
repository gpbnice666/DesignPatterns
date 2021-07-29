package com.bo.createdPatterns.builder.modelImpl;

import com.bo.createdPatterns.builder.CarModel;

public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("BMW启动");
    }

    @Override
    protected void stop() {
        System.out.println("BMWstop");
    }

    @Override
    protected void alarm() {
        System.out.println("BMW滴滴");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW 嗡嗡的发动机声");
    }
}
