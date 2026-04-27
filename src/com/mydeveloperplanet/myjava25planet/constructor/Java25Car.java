package com.mydeveloperplanet.myjava25planet.constructor;

import java.awt.Color;

public class Java25Car extends Vehicle {

    Color color;

    Java25Car(int numberOfWheels, Color color) {
        if (numberOfWheels < 4 || numberOfWheels > 6) {
            throw new IllegalArgumentException("A car must have 4, 5 or 6 wheels.");
        }
        this.color = color;
        super(numberOfWheels);
    }

    @Override
    void print() {
        System.out.println("Number of wheels: " + numberOfWheels);
        System.out.println("Color: " + color);
    }
}
