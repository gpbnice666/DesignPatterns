package com.bo.createdPatterns.abstractFactory.abs;

import com.bo.createdPatterns.abstractFactory.HuMan;

//白色人种
public abstract class AbsWhiteHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("白色人种皮肤颜色是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白色人说话了");
    }
}
