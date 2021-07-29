package com.bo.structuralPattern.bridge.colorImpl;

import com.bo.structuralPattern.bridge.Color;

public class Red implements Color {
    @Override
    public void bepaint(String shape) {
        System.out.println("红色的---->"+shape);
    }
}
