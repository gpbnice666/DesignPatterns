package com.bo.structuralPattern.adapter.objectAdapter;

public class Voltage220V {  //被适配者
    public int output220V(){
        System.out.println("电压220v");
        return 220;
    }
}