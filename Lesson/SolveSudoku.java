public class SolveSudoku{

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {0, 2, 0, 0, 0, 8, 5, 0, 0},
                {0, 4, 0, 0, 3, 0, 0, 0, 0},
                {5, 0, 3, 0, 0, 9, 0, 7, 0},
                {0, 0, 0, 8, 0, 0, 0, 4, 0},
                {9, 0, 5, 0, 6, 0, 8, 0, 0},
                {2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 1},
                {0, 3, 0, 0, 0, 0, 0, 0, 0},
                {8, 0, 6, 0, 9, 0, 4, 0, 0}
        };

        if (solveSudoku(sudokuBoard)) {
            System.out.println("Sudoku solved successfully:");
            printSudoku(sudokuBoard);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // If no number can be placed, backtrack
                }
            }
        }
        return true; // Sudoku is solved
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxStartRow + i][boxStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
