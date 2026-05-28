class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean[][] rows = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] blocks = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    if (!rows[i][val - 1] &&
                    !cols[j][val - 1] &&
                    !blocks[i / 3 * 3 + j / 3][val - 1]) {
                        rows[i][val - 1] = true;
                        cols[j][val - 1] = true;
                        blocks[i / 3 * 3 + j / 3][val - 1] = true; 
                    } else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
