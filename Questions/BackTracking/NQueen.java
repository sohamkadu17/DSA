package Questions.BackTracking;

public class NQueen {

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        System.out.println(queens(board, 0));
    }

    private static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        int r = row - 1;
        int c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r--][c--]) {
                return false;
            }
        }

// Right Diagonal alternative
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board.length) {
            if (board[r--][c++]) {
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean a : arr) {
                if (a == true) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
