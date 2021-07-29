package com.bo.createdPatterns.templateMethod.impl;

import com.bo.createdPatterns.templateMethod.CarModel;

public class Ferrari812 extends CarModel {
    @Override
    public void start() {
        System.out.println("Ferrari812 启动");
    }

    @Override
    public void stop() {
        System.out.println("Ferrari812 熄火");
    }

    @Override
    public void alarm() {
        System.out.println("Ferrari812 滴滴");
    }

    @Override
    public void engineBoom() {
        System.out.println("Ferrari812 嗡嗡");
    }
}
