package com.bo.structuralPattern.composite.absExtends;

import com.bo.structuralPattern.composite.OrganizationComponent;

import java.util.ArrayList;
import java.util.List;


// 大学类
public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    @Override
    public void print() {
        System.out.println(getName());
        organizationComponents.forEach(organizationComponent -> {
            organizationComponent.print();
        });
    }

    public void add(OrganizationComponent organizationComponent){
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    public University(String name, String des) {
        super(name, des);
    }

    public University(){}

    public String getName() {
        return super.getName();
    }

    public String getDes() {
        return super.getDes();
    }


}
