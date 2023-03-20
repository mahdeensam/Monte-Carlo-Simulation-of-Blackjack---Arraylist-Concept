/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * 
     * @param val
     */
    public Card(int val) {
        if (val < 1 || val > 13) { // || means or
            throw new IllegalArgumentException("Card value cannot be greater than 13 and less than 1");
            // The reason why the value of a card cannot be greater than 13 and less than 1
            // is because in standard playing card decks,
            // there are only 13 ranks of cards: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack,
            // Queen, and King.
            // The value of an Ace is typically considered to be 1,
            // and the value of a King is typically considered to be 13.
        }
        value = val; // a way to assign the value of the parameter val to the private instance
                     // variable value.
        // This is how the value of the card is set in the constructor.
    }

    /**
     * Returns the value of the card.
     * 
     * @return the value of the card
     */
    public int getValue() {
        // TBD
        return value;
    }

    /**
     * Returns a string representation of this card.
     * 
     * @return a string representation of this card
     */
    public String toString() {
        return Integer.toString(value);
        // TBD
    }
}