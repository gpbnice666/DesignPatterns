package com.bo.createdPatterns.prototype.copy;

public class Thing implements Cloneable{
    private String aa;

    public Thing(){
        System.out.println("thing.......");
    }

    public Thing(String aa) {
        this.aa = aa;
        System.out.println("thing........"+aa);
    }

    @Override
    protected Thing clone()  {
        Object  thing = null;
        try {
            thing = super.clone();
        }catch (Exception e){
            System.out.println("克隆失败");
        }
        return (Thing)thing;
    }
}
