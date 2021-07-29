package com.bo.createdPatterns.factory;

import com.bo.createdPatterns.factory.impl.BlackHuMan;
import com.bo.createdPatterns.factory.impl.WhiteHuMan;
import com.bo.createdPatterns.factory.impl.YellowHuMan;

//客户端
public class Client {
    public static void main(String[] args) {
        //创建抽象工厂
        AbstractHuManFactory huManFactory = new HuManFactory();

        System.out.println("--第一批黄种人--");
        YellowHuMan huMan = huManFactory.createHuMan(YellowHuMan.class);
        huMan.getColor();
        huMan.talk();
        System.out.println("--白种人--");
        WhiteHuMan huMan1 = huManFactory.createHuMan(WhiteHuMan.class);
        huMan1.getColor();
        huMan1.talk();
        System.out.println("--黑种人--");
        HuMan huMan2 = huManFactory.createHuMan(BlackHuMan.class);
        huMan2.getColor();
        huMan2.talk();
    }
}
