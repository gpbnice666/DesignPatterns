package com.bo.createdPatterns.factory;


//抽象人类创建工厂
public abstract class AbstractHuManFactory {
    /*
     *   我们这立采用类繁星(Generice),
     *   通过定义泛型对createHuMan的输入参数产生两层限制
     *      必须是Class类型
     *      返回值必须是HuMan的实现类
     *
     * */
    abstract <T extends HuMan> T createHuMan(Class<T> c);
}
