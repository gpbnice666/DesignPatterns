package com.bo.createdPatterns.abstractFactory.abs.absExtends;

import com.bo.createdPatterns.abstractFactory.abs.AbsYellowHuMan;

public class MaleYellowHuMan extends AbsYellowHuMan {
    //yellow男性
    @Override
    public void getSex() {
        System.out.println("黄人男性");
    }
}
