package com.bo.behaviourPatterns.templateMethod.impl;

import com.bo.behaviourPatterns.templateMethod.CarModel;

public class Ferrari911 extends CarModel {
    @Override
    public void start() {
        System.out.println("Ferrari911 启动");
    }

    @Override
    public void stop() {
        System.out.println("Ferrari911 熄火");
    }

    @Override
    public void alarm() {
        System.out.println("Ferrari911 滴滴");
    }

    @Override
    public void engineBoom() {
        System.out.println("Ferrari911 嗡嗡");
    }
}
