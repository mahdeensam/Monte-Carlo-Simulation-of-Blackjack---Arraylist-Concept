/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck; // ArrayList to hold the cards in the deck
    private Random rand; // Random object to shuffle the deck

    /**
     * Constructor that creates the underlying deck as an ArrayList of Card objects.
     * Initializes a Random object for shuffling the deck.
     * Calls the build() method to build the deck itself.
     */
    public Deck() {
        deck = new ArrayList<Card>(); // Initialize the ArrayList
        rand = new Random(); // Initialize the Random object
        build(); // Call the build() method to build the deck
    }

    /**
     * Builds the underlying deck as a standard 52 card deck.
     * Replaces any current deck stored in the ArrayList.
     */
    public void build() {
        // Add 4 cards of each value from 2 to 9 to the deck
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i));
            }
        }
        // Add 16 cards with the value 10 to the deck
        for (int i = 0; i < 16; i++) {
            deck.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck.
     * 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * If the deck is empty, it calls the build() method to rebuild the deck.
     * 
     * @return the first card of the deck
     */
    public Card deal() {
        if (deck.isEmpty()) {
            build(); // Rebuild the deck if it is empty
        }
        return deck.remove(0); // Return and remove the first card of the deck
    }

    /**
     * Shuffles the cards currently in the deck using the Random object.
     */
    public void shuffle() {
        Collections.shuffle(deck, rand);
    }

    /**
     * Returns a string representation of the deck.
     * 
     * @return a string representation of the deck
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : deck) {
            sb.append(c.getValue() + " ");
        }
        return sb.toString();
    }
}
