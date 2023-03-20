/* Mahdeen Ahmed Khan Sameer
 * Course: CS231B
 * Professor Max Bender
 * Feb 12, 2023
 */

public boolean playerTurnInteractive(String decisionRule){Scanner sc=new Scanner(System.in);System.out.println("Player's turn\n"+this);while(playerHand.getTotalValue()<16){if(decisionRule.equals("manual")){System.out.print("Do you want to hit? (y/n): ");String hit=sc.nextLine();if(hit.equals("y")){playerHand.add(deck.deal());}else{break;}}else if(decisionRule.equals("hitUntil17")){playerHand.add(deck.deal());}else if(decisionRule.equals("hitUntil18")){if(playerHand.getTotalValue()<18){playerHand.add(deck.deal());}else{break;}}else{System.out.println("Invalid decision rule");return false;}}return playerHand.getTotalValue()<=21;}

public int playGame(String decisionRule,boolean verbose){reset();deal();if(!playerTurnInteractive(decisionRule)){if(verbose){System.out.println("Player Busts\n"+this);}return-1;}if(!dealerTurn()){if(verbose){System.out.println("Dealer Busts\n"+this);}return 1;}int playerValue=playerHand.getTotalValue();int dealerValue=dealerHand.getTotalValue();if(playerValue>dealerValue){if(verbose){System.out.println("Player Wins\n"+this);}return 1;}else if(playerValue==dealerValue){if(verbose){System.out.println("Push\n"+this);}return 0;}else{if(verbose){System.out.println("Dealer Wins\n"+this);}return-1;}}

public class Simulation {
    public static void main(String[] args) {
        Blackjack bj = new Blackjack(1);
        bj.setReshuffleCutoff(52 * 6 - 1);
        int[] results = new int[3];
        int[] resultsHitUntil17 = new int[3];
        int[] resultsHitUntil18 = new int[3];
        for (int i = 0; i < 1000; i++) {
            int result = bj.playGame("manual", false);
            if (result == 1) {
                results[0]++;
            } else if (result == 0) {
                results[1]++;
            } else {
                results[2]++;
            }
        }
        System.out.println("Player wins: " + results[0] + "(" + (100.0 * results[0] / 1000) + "%)");
        System.out.println("Dealer wins: " + results[2] + "(" + (100.0 * results[2] / 1000) + "%)");
        System.out.println("Push: " + results[1] + "(" + (100.0 * results[1] / 1000) + "%)");
    }
}
