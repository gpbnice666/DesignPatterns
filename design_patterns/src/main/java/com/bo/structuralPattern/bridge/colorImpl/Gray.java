package com.bo.structuralPattern.bridge.colorImpl;

import com.bo.structuralPattern.bridge.Color;

public class Gray implements Color {
 
    public void bepaint(String shape) {
        System.out.println("灰色的" + shape);
    }
}