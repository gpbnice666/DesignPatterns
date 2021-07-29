package com.bo.createdPatterns.factory.impl;


import com.bo.createdPatterns.factory.HuMan;

public class BlackHuMan implements HuMan {
    @Override
    public void getColor() {
        System.out.println("黑人的皮肤是黑色的！！！");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话");
    }
}
