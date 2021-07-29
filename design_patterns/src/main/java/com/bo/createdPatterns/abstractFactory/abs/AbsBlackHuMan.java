package com.bo.createdPatterns.abstractFactory.abs;

import com.bo.createdPatterns.abstractFactory.HuMan;

public abstract class AbsBlackHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("黑人的皮肤是黑色的！！！");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话");
    }
}
