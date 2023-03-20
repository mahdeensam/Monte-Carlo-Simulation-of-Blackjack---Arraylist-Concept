/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

/*
file name:      BlackjackTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  8/28/2022

How to run:     java -ea BlackjackTests
*/

public class BlackjackTests {

    public static void blackjackTests() {

        // case 1: testing Blackjack() and Blackjack(i)
        {
            // set up
            Blackjack bj1 = new Blackjack();
            Blackjack bj2 = new Blackjack(5);

            // verify

            // test
            assert bj1 != null : "Error in Blackjack::Blackjack()";
            assert bj2 != null : "Error in Blackjack::Blackjack()";
        }

        System.out.println("*** Done testing Blackjack! ***\n");
    }

    public static void main(String[] args) {

        blackjackTests();
    }
}