package com.bo.createdPatterns.factory.impl;


import com.bo.createdPatterns.factory.HuMan;

public class WhiteHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("白色人种皮肤颜色是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白色人说话了");
    }
}
