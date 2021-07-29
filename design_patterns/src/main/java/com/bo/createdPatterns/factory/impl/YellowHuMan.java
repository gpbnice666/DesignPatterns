package com.bo.createdPatterns.factory.impl;

import com.bo.createdPatterns.factory.HuMan;

public class YellowHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("黄色人种皮肤颜色是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种说话");
    }
}
