/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.Scanner;

public class Blackjack {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private int reshuffleCutoff;

    public Blackjack(int reshuffleCutoff) {
        this.reshuffleCutoff = reshuffleCutoff;
        reset();
    }

    public Blackjack() {
        this(5);
    }

    public void reset() {
        playerHand = new Hand();
        dealerHand = new Hand();
        if (deck == null || deck.size() < reshuffleCutoff) {
            deck = new Deck();
            deck.shuffle();
        } else {
            playerHand.reset();
            dealerHand.reset();
        }
    }

    public void deal() {
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(deck.deal());
        }
        return playerHand.getTotalValue() <= 21;
    }

    public boolean playerTurnInteractive() {
        Scanner sc = new Scanner(System.in);
        while (playerHand.getTotalValue() < 16) {
            System.out.println("Your current hand is: " + playerHand);
            System.out.println("Would you like to hit or stay? (Enter 'h' for hit and 's' for stay)");
            String input = sc.nextLine();
            if (input.equals("h")) {
                playerHand.add(deck.deal());
            } else if (input.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
        return playerHand.getTotalValue() <= 21;
    }

    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.add(deck.deal());
        }
        return dealerHand.getTotalValue() <= 21;
    }

    public void setReshuffleCutoff(int cutoff) {
        this.reshuffleCutoff = cutoff;
    }

    public int getReshuffleCutoff() {
        return reshuffleCutoff;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player hand: " + playerHand + "\n");
        sb.append("Dealer hand: " + dealerHand + "\n");
        return sb.toString();
    }

    public static class Interactive {
        public static void main(String[] args) {
            Blackjack game = new Blackjack();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("New game:");
                game.reset();
                game.deal();
                game.playerTurnInteractive();
                if (game.playerHand.getTotalValue() > 21) {
                    System.out.println("Player busts. Dealer wins.");
                    continue;
                }
            }
        }
    }
}