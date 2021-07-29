package com.bo.createdPatterns.abstractFactory.impl;


import com.bo.createdPatterns.abstractFactory.HuMan;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.FemaleBlackHuMan;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.FemaleWhileHuMan;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.FemaleYellowHuMan;
import com.bo.createdPatterns.abstractFactory.HuManFactory;


//抽象工厂的具体实现
public class FemaleFeactory implements HuManFactory {
    @Override
    public HuMan createdYellowHuMan() {
        return new FemaleYellowHuMan();
    }

    @Override
    public HuMan createdWhiteHuMan() {
        return new FemaleWhileHuMan();
    }

    @Override
    public HuMan createdBlackHuMan() {
        return new FemaleBlackHuMan();
    }
}
