/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

public class Simulation {
    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        for (int i = 0; i < 1000; i++) {
            int result = bj.game(false);
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }
        System.out.println("Player Wins: " + playerWins + " (" + (double) playerWins / 10 + "%)");
        System.out.println("Dealer Wins: " + dealerWins + " (" + (double) dealerWins / 10 + "%)");
        System.out.println("Pushes: " + pushes + " (" + (double) pushes / 10 + "%)");
    }
}