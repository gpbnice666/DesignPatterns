package com.bo.structuralPattern.adapter.interfaceAdapter.impl;

import com.bo.structuralPattern.adapter.interfaceAdapter.Controller;

public class HttpController implements Controller {
    public void doHttp(){
        System.out.println("http");
    }
}
