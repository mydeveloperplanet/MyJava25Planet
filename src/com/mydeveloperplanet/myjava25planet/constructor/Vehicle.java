package com.mydeveloperplanet.myjava25planet.constructor;

public class Vehicle {

    int numberOfWheels;

    Vehicle(int numberOfWheels) {
        if (numberOfWheels < 1) {
            throw new IllegalArgumentException("a vehicle must have at least one wheel");
        }
        this.numberOfWheels = numberOfWheels;
        print();
    }

    void print() {
        System.out.println("Number of wheels: " + numberOfWheels);
    }
}
