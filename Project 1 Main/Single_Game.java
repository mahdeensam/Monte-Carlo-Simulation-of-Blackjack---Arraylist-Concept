/* Mahdeen Ahmed Khan Sameer
 * Project 1
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;

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
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());
    }

    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(deck.deal());
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
        reshuffleCutoff = cutoff;
    }

    public int getReshuffleCutoff() {
        return reshuffleCutoff;
    }

    public String toString() {
        return "Player Hand: " + playerHand + "\nDealer Hand: " + dealerHand;
    }

    public int game(boolean verbose) {
        reset();
        deal();
        if (!playerTurn()) {
            if (verbose) {
                System.out.println("Player Busts\n" + this);
            }
            return -1;
        }
        if (!dealerTurn()) {
            if (verbose) {
                System.out.println("Dealer Busts\n" + this);
            }
            return 1;
        }
        int playerValue = playerHand.getTotalValue();
        int dealerValue = dealerHand.getTotalValue();
        if (playerValue > dealerValue) {
            if (verbose) {
                System.out.println("Player Wins\n" + this);
            }
            return 1;
        } else if (playerValue == dealerValue) {
            if (verbose) {
                System.out.println("Push\n" + this);
            }
            return 0;
        } else {
            if (verbose) {
                System.out.println("Dealer Wins\n" + this);
            }
            return -1;
        }
    }

}
