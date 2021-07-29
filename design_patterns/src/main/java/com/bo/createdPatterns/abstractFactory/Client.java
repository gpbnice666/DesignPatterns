package com.bo.createdPatterns.abstractFactory;

import com.bo.createdPatterns.abstractFactory.impl.FemaleFeactory;
import com.bo.createdPatterns.abstractFactory.impl.MaleFactory;

public class Client {
    public static void main(String[] args) {
        //成产男性
        HuManFactory maleFactory = new MaleFactory();
        //生成女性
        HuManFactory femaleFeactory = new FemaleFeactory();
        System.out.println("生成黄中人男性");
        HuMan huMan = maleFactory.createdYellowHuMan();
        huMan.getColor();
        huMan.talk();
        huMan.getSex();
        System.out.println("生成黄中人女性");
        HuMan huMan1 = femaleFeactory.createdYellowHuMan();
        huMan1.getColor();
        huMan1.talk();
        huMan1.getSex();
    }
}
