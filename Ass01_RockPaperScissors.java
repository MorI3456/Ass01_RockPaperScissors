import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerAMove, playerBMove;

        // Loop to keep the game running until the players decide to stop
        while (true) {
            // Get valid move from Player A
            playerAMove = getValidMove(scanner, "Player A");

            // Get valid move from Player B
            playerBMove = getValidMove(scanner, "Player B");

            // Display the results and determine the winner
            determineWinner(playerAMove, playerBMove);

            // Ask if they want to play again
            System.out.println("Do you want to play again? (Y/N)");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }

    // Function to get a valid move from a player
    public static String getValidMove(Scanner scanner, String playerName) {
        String move;
        while (true) {
            System.out.println(playerName + ", please enter your move (r, p, or s): ");
            move = scanner.nextLine().trim().toLowerCase();
            if (move.equals("r") || move.equals("p") || move.equals("s")) {
                break;
            }
            System.out.println("Invalid move. Please try again.");
        }
        return move;
    }

    // Function to determine the winner and display the result
    public static void determineWinner(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            System.out.println("It's a tie! Both players chose " + convertMoveToWord(playerAMove));
        } else if ((playerAMove.equals("r") && playerBMove.equals("s")) ||
                (playerAMove.equals("p") && playerBMove.equals("r")) ||
                (playerAMove.equals("s") && playerBMove.equals("p"))) {
            System.out.println("Player A wins! " + getResultText(playerAMove, playerBMove));
        } else {
            System.out.println("Player B wins! " + getResultText(playerBMove, playerAMove));
        }
    }

    // Helper function to convert the move (r, p, s) to a word (Rock, Paper, Scissors)
    public static String convertMoveToWord(String move) {
        switch (move) {
            case "r": return "Rock";
            case "p": return "Paper";
            case "s": return "Scissors";
            default: return "";
        }
    }

    // Helper function to generate the result text
    public static String getResultText(String winningMove, String losingMove) {
        if (winningMove.equals("r") && losingMove.equals("s")) {
            return "Rock beats Scissors!";
        } else if (winningMove.equals("p") && losingMove.equals("r")) {
            return "Paper covers Rock!";
        } else if (winningMove.equals("s") && losingMove.equals("p")) {
            return "Scissors cuts Paper!";
        }
        return "";
    }
}
