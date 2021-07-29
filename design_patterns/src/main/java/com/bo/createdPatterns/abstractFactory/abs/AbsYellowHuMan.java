package com.bo.createdPatterns.abstractFactory.abs;

import com.bo.createdPatterns.abstractFactory.HuMan;

public abstract class AbsYellowHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("黄色人种皮肤颜色是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种说话");
    }
}
