package com.bo.structuralPattern.adapter.objectAdapter;

public class Client {
    public static void main(String[] args) {
        VotageAdapter votageAdapter = new VotageAdapter(new Voltage220V());
        int output5V = votageAdapter.output5V();
    }
}
