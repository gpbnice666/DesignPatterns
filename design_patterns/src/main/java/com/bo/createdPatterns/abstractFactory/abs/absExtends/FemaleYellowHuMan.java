package com.bo.createdPatterns.abstractFactory.abs.absExtends;

import com.bo.createdPatterns.abstractFactory.abs.AbsYellowHuMan;

public class FemaleYellowHuMan extends AbsYellowHuMan {
    //黄种人的女人
    @Override
    public void getSex() {
        System.out.println("黄人女性");
    }
}
