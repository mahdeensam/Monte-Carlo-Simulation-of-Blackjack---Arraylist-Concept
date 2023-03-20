/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;
import java.util.List;

public class Simulation_std {
    public static void main(String[] args) {
        int M = 10; // Number of games in a single simulation
        int N = 3; // Number of simulations
        List<Double> winPercentages = new ArrayList<>(); // List to store the win percentages of each simulation
        for (int i = 0; i < N; i++) {
            Blackjack bj = new Blackjack();
            int playerWins = 0;
            int dealerWins = 0;
            int pushes = 0;
            for (int j = 0; j < M; j++) {
                int result = bj.game(false);
                if (result == 1) {
                    playerWins++;
                } else if (result == -1) {
                    dealerWins++;
                } else {
                    pushes++;
                }
            }
            double winPercentage = (double) playerWins / M;
            winPercentages.add(winPercentage);
        }
        // Calculate the mean of the win percentages
        double mean = 0;
        for (double winPercentage : winPercentages) {
            mean += winPercentage;
        }
        mean /= N;
        // Calculate the standard deviation of the win percentages
        double standardDeviation = 0;
        for (double winPercentage : winPercentages) {
            standardDeviation += Math.pow(winPercentage - mean, 2);
        }
        standardDeviation = Math.sqrt(standardDeviation / N);
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }
}
