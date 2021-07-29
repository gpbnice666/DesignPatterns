package com.bo.structuralPattern.bridge.shapeImpl;

import com.bo.structuralPattern.bridge.Shape;

public class Rectangle extends Shape {
 
    public void draw() {
        color.bepaint("长方形");
    }
 
}