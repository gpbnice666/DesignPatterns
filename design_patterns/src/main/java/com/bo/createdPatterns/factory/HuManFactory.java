package com.bo.createdPatterns.factory;

//人类创建工厂
public class HuManFactory extends AbstractHuManFactory {
    @Override
    public  <T extends HuMan> T createHuMan(Class<T> c) {
        //定义一个人类
        HuMan huMan=null;
        try {
            //产生一个人类
            huMan = (HuMan) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            System.out.println("人种生产错误。。。。。");
            System.out.println(e.getMessage());
        }
        return (T) huMan;
    }
}
