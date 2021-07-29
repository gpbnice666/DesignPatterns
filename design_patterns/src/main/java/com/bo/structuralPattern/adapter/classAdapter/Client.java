package com.bo.structuralPattern.adapter.classAdapter;

public class Client {
    public static void main(String[] args) {
        VotageAdapter votageAdapter = new VotageAdapter();
        int output5V = votageAdapter.output5V();
    }
}
