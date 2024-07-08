package org.example;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1; // Dice roll between 1 and 6
    }
}
