package com.bo.createdPatterns.abstractFactory.abs.absExtends;

import com.bo.createdPatterns.abstractFactory.abs.AbsWhiteHuMan;

public class FemaleWhileHuMan extends AbsWhiteHuMan {

    @Override
    public void getSex() {
        System.out.println("白色人女性");
    }
}
