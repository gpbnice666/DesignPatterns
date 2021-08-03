package com.bo.behaviourPatterns.strategy.impl;

import com.bo.behaviourPatterns.strategy.CrabCooking;

import javax.swing.*;

public class BraisedCrabs extends JLabel implements CrabCooking {
    private static final long serialVersionUID = 1L;
    public void CookingMethod() {
        this.setIcon(new ImageIcon("src/main/java/com/bo/behaviourPatterns/strategy/BraisedCrabs.png"));
        this.setHorizontalAlignment(CENTER);
    }
}