package com.bo.createdPatterns.abstractFactory.impl;

import com.bo.createdPatterns.abstractFactory.HuMan;
import com.bo.createdPatterns.abstractFactory.HuManFactory;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.MaleBlackHuMan;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.MaleWhileHuMan;
import com.bo.createdPatterns.abstractFactory.abs.absExtends.MaleYellowHuMan;

public class MaleFactory implements HuManFactory {
    @Override
    public HuMan createdYellowHuMan() {
        return new MaleYellowHuMan();
    }

    @Override
    public HuMan createdWhiteHuMan() {
        return new MaleWhileHuMan();
    }

    @Override
    public HuMan createdBlackHuMan() {
        return new MaleBlackHuMan();
    }
}
