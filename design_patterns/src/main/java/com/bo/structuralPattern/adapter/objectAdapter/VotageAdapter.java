package com.bo.structuralPattern.adapter.objectAdapter;

//适配器
public class VotageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VotageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }
    public VotageAdapter() {
    }

    public int output5V() {
        int output220V = voltage220V.output220V();
        System.out.println("降压。。。。");
        return output220V/44;
    }
}