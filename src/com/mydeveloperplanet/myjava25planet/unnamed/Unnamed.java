package com.mydeveloperplanet.myjava25planet.unnamed;

public class Unnamed {

    static void main() {
        namedVariable();
        unnamedVariable();
        namedPattern();
        unnamedPattern();
    }

    private static void namedVariable() {
        String s = "data";
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Bad integer: " + s);
        }
    }

    private static void unnamedVariable() {
        String s = "data";
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException _) {
            System.out.println("Bad integer: " + s);
        }
    }

    private static void namedPattern() {
        AbstractFruit fruit = new Apple();
        switch (fruit) {
            case Apple apple -> System.out.println("This is an apple");
            case Pear pear -> System.out.println("This is a pear");
            case Orange orange -> System.out.println("This is an orange");
            default -> throw new IllegalStateException("Unexpected value: " + fruit);
        }
    }

    private static void unnamedPattern() {
        AbstractFruit fruit = new Apple();
        switch (fruit) {
            case Apple _ -> System.out.println("This is an apple");
            case Pear _ -> System.out.println("This is a pear");
            case Orange _ -> System.out.println("This is an orange");
            default -> throw new IllegalStateException("Unexpected value: " + fruit);
        }
    }

}
