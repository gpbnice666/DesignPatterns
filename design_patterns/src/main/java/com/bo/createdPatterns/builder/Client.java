package com.bo.createdPatterns.builder;

import com.bo.createdPatterns.builder.builderImpl.BigGBuilder;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engineBoom");
        sequence.add("start");
        sequence.add("stop");
        CarBuilder bigGBuilder = new BigGBuilder();
        bigGBuilder.setSequence(sequence);
        CarModel carModel = bigGBuilder.getCarModel();
        carModel.run();
    }
}
