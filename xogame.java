import java.util.Scanner;

public class xogame {
    private static char[][] xoBoard = new char[3][3];
    private static char currentSymbol = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        while (true) {
            printBoard();
            System.out.println("Player " + currentSymbol + ", enter row (0-2) and column (0-2):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                xoBoard[row][col] = currentSymbol;

                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentSymbol + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xoBoard[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("XO Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(xoBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               xoBoard[row][col] == '-';
    }

    private static void switchPlayer() {
        currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xoBoard[i][j] == '-') return false;
            }
        }
        return true;
    }

    private static boolean checkWin() {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (xoBoard[i][0] == currentSymbol &&
                xoBoard[i][1] == currentSymbol &&
                xoBoard[i][2] == currentSymbol) return true;
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (xoBoard[0][j] == currentSymbol &&
                xoBoard[1][j] == currentSymbol &&
                xoBoard[2][j] == currentSymbol) return true;
        }

        // Diagonals
        if (xoBoard[0][0] == currentSymbol &&
            xoBoard[1][1] == currentSymbol &&
            xoBoard[2][2] == currentSymbol) return true;

        if (xoBoard[0][2] == currentSymbol &&
            xoBoard[1][1] == currentSymbol &&
            xoBoard[2][0] == currentSymbol) return true;

        return false;
    }
}
