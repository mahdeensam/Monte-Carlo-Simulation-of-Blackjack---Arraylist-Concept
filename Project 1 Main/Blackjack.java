/* Mahdeen Ahmed Khan Sameer
 * Project 1
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

// This class represents a game of Blackjack, with a deck of cards, a player hand, and a dealer hand.
public class Blackjack {
    // Instance variables
    private Deck deck; // A deck of cards
    private Hand playerHand; // The player's hand
    private Hand dealerHand; // The dealer's hand
    private int reshuffleCutoff; // The number of cards left in the deck when we need to reshuffle

    // Constructor that takes a reshuffle cutoff
    public Blackjack(int reshuffleCutoff) {
        this.reshuffleCutoff = reshuffleCutoff;
        reset(); // Resets the game
    }

    // Default constructor that sets reshuffle cutoff to 5
    public Blackjack() {
        this(5);
    }

    // Resets the game
    public void reset() {
        playerHand = new Hand(); // Resets player's hand
        dealerHand = new Hand(); // Resets dealer's hand
        // If the deck is null or has less than reshuffle cutoff number of cards, create
        // a new deck and shuffle it
        if (deck == null || deck.size() < reshuffleCutoff) {
            deck = new Deck();
            deck.shuffle();
        } else {
            playerHand.reset(); // Resets player's hand
            dealerHand.reset(); // Resets dealer's hand
        }
    }

    // Deals cards to the player and dealer
    public void deal() {
        playerHand.add(deck.deal()); // Adds card to player's hand
        dealerHand.add(deck.deal()); // Adds card to dealer's hand
        playerHand.add(deck.deal()); // Adds card to player's hand
        dealerHand.add(deck.deal()); // Adds card to dealer's hand
    }

    // Player's turn to hit until they either stand or bust
    public boolean playerTurn() {
        while (playerHand.getTotalValue() < 16) {
            playerHand.add(deck.deal()); // Adds card to player's hand
        }
        return playerHand.getTotalValue() <= 21; // Returns true if player hasn't busted
    }

    // Dealer's turn to hit until they have at least 17 or bust
    public boolean dealerTurn() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.add(deck.deal()); // Adds card to dealer's hand
        }
        return dealerHand.getTotalValue() <= 21; // Returns true if dealer hasn't busted
    }

    // Setter method for reshuffle cutoff
    public void setReshuffleCutoff(int cutoff) {
        this.reshuffleCutoff = cutoff;
    }

    // Getter method for reshuffle cutoff
    public int getReshuffleCutoff() {
        return reshuffleCutoff;
    }

    // Returns a string representation of the player and dealer hands
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player hand: " + playerHand + "\n");
        sb.append("Dealer hand: " + dealerHand + "\n");
        return sb.toString();
    }

    public int game(boolean verbose) {
        reset(); // Resets the game (creates new decks and hands)
        deal(); // Deals two cards to the player and two cards to the dealer
        if (!playerTurn()) { // If the player has a hand with a value over 21 (bust)
            if (verbose) { // If verbose mode is enabled
                System.out.println("Player busts."); // Print message
                System.out.println("Player hand: " + playerHand); // Print the player's hand
                System.out.println("Dealer hand: " + dealerHand); // Print the dealer's hand
            }
            return -1; // Return -1 (indicates the player lost)
        }
        if (!dealerTurn()) { // If the dealer has a hand with a value over 21 (bust)
            if (verbose) { // If verbose mode is enabled
                System.out.println("Dealer busts."); // Print message
                System.out.println("Player hand: " + playerHand); // Print the player's hand
                System.out.println("Dealer hand: " + dealerHand); // Print the dealer's hand
            }
            return 1; // Return 1 (indicates the player won)
        }
        int playerTotal = playerHand.getTotalValue(); // Get the total value of the player's hand
        int dealerTotal = dealerHand.getTotalValue(); // Get the total value of the dealer's hand
        if (playerTotal > dealerTotal) { // If the player's hand has a higher value than the dealer's hand
            if (verbose) { // If verbose mode is enabled
                System.out.println("Player wins."); // Print message
                System.out.println("Player hand: " + playerHand); // Print the player's hand
                System.out.println("Dealer hand: " + dealerHand); // Print the dealer's hand
            }
            return 1; // Return 1 (indicates the player won)
        } else if (playerTotal == dealerTotal) { // If the player's hand and dealer's hand have the same value
            if (verbose) { // If verbose mode is enabled
                System.out.println("Push."); // Print message
                System.out.println("Player hand: " + playerHand); // Print the player's hand
                System.out.println("Dealer hand: " + dealerHand); // Print the dealer's hand
            }
            return 0; // Return 0 (indicates a tie)
        } else { // If the dealer's hand has a higher value than the player's hand
            if (verbose) { // If verbose mode is enabled
                System.out.println("Dealer wins."); // Print message
                System.out.println("Player hand: " + playerHand); // Print the player's hand
                System.out.println("Dealer hand: " + dealerHand); // Print the dealer's hand
            }
            return -1; // Return -1 (indicates the player lost)
        }
    }

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        int result = game.game(true); // Play a game of blackjack with verbose mode enabled
        System.out.println("Result: " + result); // Print the result of the game (1 for win, 0 for tie, -1 for loss)
    }
}