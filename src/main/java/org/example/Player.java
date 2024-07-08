package org.example;

public class Player {
    private String name;
    private int shareValue;
    private Dice dice;

    public Player(String name, int shareValue) {
        this.name = name;
        this.shareValue = shareValue;
        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public int getShareValue() {
        return shareValue;
    }

    public void reduceShareValue(int value) {
        shareValue -= value;
        if (shareValue < 0) {
            shareValue = 0;
        }
    }

    public int rollDice() {
        return dice.roll();
    }

    public boolean isDefeated() {
        return this.shareValue == 0;
    }
}
