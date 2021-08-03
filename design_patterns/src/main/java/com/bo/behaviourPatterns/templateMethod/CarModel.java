package com.bo.behaviourPatterns.templateMethod;


//车的模型
public abstract class CarModel {
    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();

    public  void run(){
        //启动车子
        this.start();
        //嗡嗡的发动机声音
        this.engineBoom();
        //滴滴
        this.alarm();
        //熄火
        this.start();
    }
}
