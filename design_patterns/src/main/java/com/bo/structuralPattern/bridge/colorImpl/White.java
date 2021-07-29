package com.bo.structuralPattern.bridge.colorImpl;

import com.bo.structuralPattern.bridge.Color;

public class White implements Color {
 
    public void bepaint(String shape) {
        System.out.println("白色的" + shape);
    }
 
}