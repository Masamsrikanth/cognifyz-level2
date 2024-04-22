import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    private static boolean gameEnded;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            startGame();
            while (!gameEnded) {
                displayBoard();
                makeMove(scanner);
                checkGameStatus();
                switchPlayer();
            }
            displayBoard();
            System.out.println("Do you want to play again? (yes/no)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
    }

    private static void startGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        System.out.println("Let's play Tic-Tac-Toe!");
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void makeMove(Scanner scanner) {
        int row, col;
        do {
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));
        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            System.out.println("Invalid move! Try again.");
            return false;
        }
        return true;
    }

    private static void checkGameStatus() {
        if (checkWinner()) {
            gameEnded = true;
            System.out.println("Player " + currentPlayer + " wins!");
        } else if (checkDraw()) {
            gameEnded = true;
            System.out.println("It's a draw!");
        }
    }

    private static boolean checkWinner() {
        // Check rows, columns, and diagonals
        return (checkRow() || checkColumn() || checkDiagonal());
    }

    private static boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumn() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonal() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
