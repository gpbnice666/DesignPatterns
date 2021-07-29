package com.bo.structuralPattern.adapter.interfaceAdapter;


import org.springframework.web.servlet.DispatcherServlet;

/**
  A instanceof B
  如果返回true A就是B的子类/是B的实例
 */

public class Client {
    public static void main(String[] args) {
        aa aa = new bb();
        bb bb = new bb();
        System.out.println(bb instanceof aa);
    }
}

interface aa{}

class  bb implements aa{
    public static void main(String[] args) {
        //DispatcherServlte dispatcherServlte;
        DispatcherServlet dispatcherServlet;
    }
}

