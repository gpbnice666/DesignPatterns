package com.bo.structuralPattern.composite.absExtends;

import com.bo.structuralPattern.composite.OrganizationComponent;


//叶子节点 系
public class Deparment extends OrganizationComponent {
    @Override
    public void print() {
        System.out.println("--------------------"+getName()+"---------------------");
    }

    public Deparment(String name, String des) {
        super(name, des);
    }

    public String getName() {
        return super.getName();
    }

    public String getDes() {
        return super.getDes();
    }
}
