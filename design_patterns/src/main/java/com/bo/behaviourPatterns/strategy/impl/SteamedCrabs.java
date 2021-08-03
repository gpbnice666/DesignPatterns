package com.bo.behaviourPatterns.strategy.impl;

import com.bo.behaviourPatterns.strategy.CrabCooking;

import javax.swing.*;

public class SteamedCrabs extends JLabel implements CrabCooking {
    @Override
    public void CookingMethod() {
        this.setIcon(new ImageIcon("src/main/java/com/bo/behaviourPatterns/strategy/SteamedCrabs.png"));
        this.setHorizontalAlignment(CENTER);
    }
}
