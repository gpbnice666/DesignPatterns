package com.bo.structuralPattern.bridge;


//抽象层
public abstract class Shape {

    // 依赖与 颜色对象
    protected Color color;

    //设置颜色
    public void setColor(Color color) {
        this.color = color;
    }

    protected abstract void draw();
}
