package org.example;

public class Game {
    private Player playerA;
    private Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
        System.out.println("Game starts!");
        while (!playerA.isDefeated() && !playerB.isDefeated()) {
            takeTurn(playerA, playerB);
            if (playerB.isDefeated()) {
                System.out.println(playerB.getName() + " has been defeated!");
                break;
            }
            takeTurn(playerB, playerA);
            if (playerA.isDefeated()) {
                System.out.println(playerA.getName() + " has been defeated!");
                break;
            }
        }
        System.out.println("Game ends!");
    }

    private void takeTurn(Player currentPlayer, Player opponent) {
        int diceValue = currentPlayer.rollDice();
        System.out.println(currentPlayer.getName() + " rolls the dice and gets: " + diceValue);
        opponent.reduceShareValue(diceValue);
        System.out.println(opponent.getName() + "'s share value is now: " + opponent.getShareValue());
    }

    public static void main(String[] args) {
        Player playerA = new Player("Player A", 100);
        Player playerB = new Player("Player B", 100);

        Game game = new Game(playerA, playerB);
        game.start();
    }
}

