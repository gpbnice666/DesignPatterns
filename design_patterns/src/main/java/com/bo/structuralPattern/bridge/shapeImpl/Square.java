package com.bo.structuralPattern.bridge.shapeImpl;

import com.bo.structuralPattern.bridge.Shape;

public class Square extends Shape {
 
    public void draw() {
        color.bepaint("正方形");
    }
 
}