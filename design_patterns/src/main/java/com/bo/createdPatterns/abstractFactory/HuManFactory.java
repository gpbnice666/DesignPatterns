package com.bo.createdPatterns.abstractFactory;

//抽象工厂定义
public interface HuManFactory {
    //创建黄色人
    HuMan createdYellowHuMan();
    //定义白色人种
    HuMan createdWhiteHuMan();
    //制造一个黑人
    HuMan createdBlackHuMan();
}
