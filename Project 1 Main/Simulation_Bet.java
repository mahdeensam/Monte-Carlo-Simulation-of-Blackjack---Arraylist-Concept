//Extension5
/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

public class Simulation_Bet {
    public static void main(String[] args) {
        Blackjack bj = new Blackjack();
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        int currentBet = 1; // Start with a bet of $1
        int totalWinnings = 0; // Keep track of the player's total winnings
        for (int i = 0; i < 1000; i++) {
            int result = bj.game(false);
            if (result == 1) {
                playerWins++;
                totalWinnings += currentBet;
                currentBet = 1; // Reset the bet after a win
            } else if (result == -1) {
                dealerWins++;
                currentBet *= 2; // Double the bet after a loss
            } else {
                pushes++;
                currentBet = 1; // Reset the bet after a push
            }
        }
        System.out.println("Player Wins: " + playerWins + " (" + (double) playerWins / 10 + "%)");
        System.out.println("Dealer Wins: " + dealerWins + " (" + (double) dealerWins / 10 + "%)");
        System.out.println("Pushes: " + pushes + " (" + (double) pushes / 10 + "%)");
        System.out.println("Total Winnings: $" + totalWinnings);
    }
}
