/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

public class Extension3 {
    public static void main(String[] args) {
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        Blackjack bj = new Blackjack(52 * 5); // reshuffle only if 5 or fewer decks left
        bj.setReshuffleCutoff(52 * 5);
        for (int i = 0; i < 1000; i++) {
            int result = bj.playGame(false);
            if (result == 1) {
                playerWins++;
            } else if (result == -1) {
                dealerWins++;
            } else {
                pushes++;
            }
        }
        System.out.println("Player wins: " + playerWins + " (" + (100.0 * playerWins / 1000) + "%)");
        System.out.println("Dealer wins: " + dealerWins + " (" + (100.0 * dealerWins / 1000) + "%)");
        System.out.println("Pushes: " + pushes + " (" + (100.0 * pushes / 1000) + "%)");
    }
}
