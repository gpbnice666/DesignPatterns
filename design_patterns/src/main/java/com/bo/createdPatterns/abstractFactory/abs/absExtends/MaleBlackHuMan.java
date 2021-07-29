package com.bo.createdPatterns.abstractFactory.abs.absExtends;

import com.bo.createdPatterns.abstractFactory.abs.AbsBlackHuMan;

public class MaleBlackHuMan extends AbsBlackHuMan {
    @Override
    public void getSex() {
        System.out.println("黑色女性");
    }
}
