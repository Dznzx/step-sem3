/*
 * Day 1 - Problem 1: Rock-Paper-Scissors Game
 * Simulates N rounds of Rock-Paper-Scissors between a player (predefined
 * moves, for a repeatable demo) and the computer (random moves), then
 * prints a round-by-round table and a final win/loss/draw summary.
 */
import java.util.Random;

public class Problem1_RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int round = 1; round <= playerMoves.length; round++) {
            String playerMove = playerMoves[round - 1];
            String computerMove = generateComputerMove();
            String result = playRound(playerMove, computerMove);

            System.out.println(round + " | " + playerMove + " | " + computerMove + " | " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / playerMoves.length;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");
    }

    private static String generateComputerMove() {
        Random random = new Random();
        return MOVES[random.nextInt(MOVES.length)];
    }

    private static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        boolean playerWins = (playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }
}
