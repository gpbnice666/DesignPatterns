package com.bo.structuralPattern.bridge.colorImpl;

import com.bo.structuralPattern.bridge.Color;

public class Black implements Color {
 
    public void bepaint(String shape) {
        System.out.println("黑色的" + shape);
    }
}