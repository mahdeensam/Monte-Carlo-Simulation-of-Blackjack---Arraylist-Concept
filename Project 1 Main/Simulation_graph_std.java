/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Simulation_std {
    public static void main(String[] args) {
        int[] Ms = new int[] { 100, 200, 500, 1000, 2000, 5000, 10000 }; // Number of games in each simulation
        List<Double> standardDeviations = new ArrayList<>(); // List to store the standard deviations for each M value
        for (int M : Ms) {
            List<Double> winPercentages = new ArrayList<>(); // List to store the win percentages of each simulation
            for (int i = 0; i < 10; i++) {
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
            double mean = 0;
            for (double winPercentage : winPercentages) {
                mean += winPercentage;
            }
            mean /= 10;
            double standardDeviation = 0;
            for (double winPercentage : winPercentages) {
                standardDeviation += Math.pow(winPercentage - mean, 2);
            }
            standardDeviation = Math.sqrt(standardDeviation / 10);
            standardDeviations.add(standardDeviation);
        }
        // Create a XYSeriesCollection to store the data
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("Standard Deviation");
        for (int i = 0; i < Ms.length; i++) {
            series.add(Ms[i], standardDeviations.get(i));
        }
        dataset.addSeries(series);
        // Create a chart using the data
        JFreeChart chart = ChartFactory.createScatterPlot(
                "Standard Deviation vs Number of Games", // Chart title
                "Number of Games (M)", // X-axis label
                "Standard Deviation", // Y-axis label
                dataset);
        // Show the chart
        ChartFrame frame = new ChartFrame("Standard Deviation vs Number of Games", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
