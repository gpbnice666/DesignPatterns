package com.bo.structuralPattern.composite.absExtends;

import com.bo.structuralPattern.composite.OrganizationComponent;

import java.util.ArrayList;
import java.util.List;

// 学院
public class College extends OrganizationComponent {
    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    @Override
    public void print() {
        System.out.println("--------------------"+getName()+"---------------------");
        organizationComponents.forEach(organizationComponent -> {
            organizationComponent.print();
        });
    }

    @Override
    public void add(OrganizationComponent organizationComponent){
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    public College(String name, String des) {
        super(name, des);
    }

    public College(){}

    public String getName() {
        return super.getName();
    }

    public String getDes() {
        return super.getDes();
    }

}
