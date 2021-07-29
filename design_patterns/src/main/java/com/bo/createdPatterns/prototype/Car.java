package com.bo.createdPatterns.prototype;

import java.io.*;


public class Car  implements Cloneable, Serializable {



    private String carName;
    private int carMoney;
    private Integer speed;
    private Author author;

    @Override
    protected Car clone()  {
        Object clone = null;
        try {
            clone = super.clone();
            Car carClone=(Car)clone;
            //引用数据单独处理
            Author clone1 = author.clone();
            carClone.setAuthor(clone1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (Car)clone;
    }

    /**
     * 序列化实现深拷贝
     * @return
     * @throws CloneNotSupportedException
     */

    protected Car carClone()  {
        Object object=null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
             object = objectInputStream.readObject();
        }catch (Exception e){
            System.out.println("拷贝失败");
            System.out.println(e.getMessage());
        }
        return (Car)object;
    }


    public Car(){
        System.out.println("car............");
    }

    public Car(String carName, int carMoney, Integer speed, Author author) {
        this.carName = carName;
        this.carMoney = carMoney;
        this.speed = speed;
        this.author = author;
        System.out.println("car...");
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarMoney() {
        return carMoney;
    }

    public void setCarMoney(int carMoney) {
        this.carMoney = carMoney;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
