package com.bo.structuralPattern.adapter.classAdapter;

//适配器
public class VotageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        int output220V = output220V();
        System.out.println("降压。。。。");
        return output220V/44;
    }
}
