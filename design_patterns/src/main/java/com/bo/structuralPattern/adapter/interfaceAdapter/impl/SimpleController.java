package com.bo.structuralPattern.adapter.interfaceAdapter.impl;

import com.bo.structuralPattern.adapter.interfaceAdapter.Controller;

public class SimpleController implements Controller {
    public void doSimple(){
        System.out.println("simple");
    }
}
