package com.bo.structuralPattern.proxy.cglibProxy.dao;

public class UserDao {

    public void save() {
        System.out.println("----已经保存数据!----");
    }

    public static void update(int a){
        System.out.println("----已经修改数据!----"+a);
    }

    public final void query(int a,String b){
        System.out.println("----已经修改数据!----"+a);
    }
}
