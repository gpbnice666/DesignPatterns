package com.bo.createdPatterns.abstractFactory.abs.absExtends;

import com.bo.createdPatterns.abstractFactory.abs.AbsWhiteHuMan;

public class MaleWhileHuMan extends AbsWhiteHuMan {
    @Override
    public void getSex() {
        System.out.println("白色人男性");
    }
}
