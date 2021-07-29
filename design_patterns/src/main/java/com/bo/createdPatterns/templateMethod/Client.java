package com.bo.createdPatterns.templateMethod;

import com.bo.createdPatterns.templateMethod.impl.Ferrari812;
import com.bo.createdPatterns.templateMethod.impl.Ferrari911;

public class Client {
    public static void main(String[] args) {
        CarModel ferrari812 = new Ferrari812();
        ferrari812.run();
        System.out.println("--------------------------");
        CarModel ferrari911 = new Ferrari911();
        ferrari911.run();
    }
}
