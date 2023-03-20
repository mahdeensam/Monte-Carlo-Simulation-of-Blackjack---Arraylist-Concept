/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

/*
file name:      DeckTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea DeckTests
*/

public class DeckTests {

    public static void deckTests() {

        // case 1: testing Deck() and size()
        {
            // set up
            Deck d1 = new Deck();

            // verify
            System.out.println(d1);

            // test
            assert d1 != null : "Error in Deck::Deck()";
            assert d1.size() == 52 : "Error in Deck::Deck()";
        }

        // case 2: testing deal()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            Card c1 = d1.deal();

            assert d1 != null : "Error in Deck::deal()";
            assert c1 != null : "Error in Deck::deal()";
            assert d1.size() == 51 : "Error in Deck::deal()";
        }

        // case 3: testing build()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();
            d1.build();

            assert d1 != null : "Error in Deck::build()";
            assert c1 != null : "Error in Deck::deal()";
            assert c2 != null : "Error in Deck::deal()";
            assert c3 != null : "Error in Deck::deal()";
            assert d1.size() == 52 : "Error in Deck::build()";
        }

        // case 4: testing shuffle()
        {
            // set up
            Deck d1 = new Deck();

            // verify

            // test
            String before = d1.toString();
            d1.shuffle();
            String after = d1.toString();

            assert !before.equals(after) : "Error in Deck::shuffle()";
            assert d1.size() == 52 : "Error in Deck::shuffle()";
        }

        // todo: add case to check correct number of each card
        // todo: add case to check reshuffle randomness

        System.out.println("*** Done testing Deck! ***\n");
    }

    public static void main(String[] args) {

        deckTests();
    }
}