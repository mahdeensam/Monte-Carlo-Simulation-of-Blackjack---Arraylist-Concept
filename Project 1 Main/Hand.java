/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList; //to hold the Card objects

public class Hand {
    private ArrayList<Card> cards;

    /**
     * Creates an empty hand as an ArrayList of Cards.
     */
    public Hand() {
        cards = new ArrayList<Card>();
    }

    /**
     * Removes any cards currently in the hand.
     */
    public void reset() {
        cards.clear();
    }

    /**
     * Adds the specified card to the hand.
     * 
     * @param card the card to be added to the hand
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * Returns the number of cards in the hand.
     * 
     * @return the number of cards in the hand
     */
    public int size() {
        return cards.size();
    }

    /**
     * Returns the card in the hand specified by the given index.
     * 
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index) {
        return cards.get(index);
    }

    /**
     * Returns the summed value over all cards in the hand.
     * 
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue() {
        int total = 0;
        for (Card card : cards) {
            total += card.getValue();
        }
        return total;
    }

    /**
     * Returns a string representation of the hand.
     * 
     * @return a string representation of the hand
     */

    public String toString() {
        // Create a StringBuilder object to build the string representation of the hand
        StringBuilder sb = new StringBuilder();

        // Add the opening square bracket to the StringBuilder
        sb.append("[");

        // Iterate over the cards in the hand
        for (int i = 0; i < cards.size(); i++) {
            // Append the value of the current card to the StringBuilder
            sb.append(cards.get(i).getValue());

            // If the current card is not the last card in the hand, add a comma and a space
            // to the StringBuilder
            if (i < cards.size() - 1) {
                sb.append(", ");
            }
        }

        // Add the closing square bracket and the string " : " to the StringBuilder
        sb.append("] : ");

        // Retrieve the total value of the hand and add it to the StringBuilder
        sb.append(getTotalValue());

        // Return the contents of the StringBuilder as the string representation of the
        // hand
        return sb.toString();
    }
}
