// class Solution {
//     public static List<List<Integer>> dir = new ArrayList<>();

//     public boolean exist(char[][] board, String word) {
//         if (word.length() > board.length * board[0].length) return false;
//         boolean[][] visited = new boolean[board.length][board[0].length];
//         dir.add(List.of(1, 0));
//         dir.add(List.of(-1, 0));
//         dir.add(List.of(0, -1));
//         dir.add(List.of(0, 1));
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 if (word.charAt(0) == board[i][j]) {
//                     if (dfs(0, i, j, word, board, visited)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     private boolean dfs(int cur, int x, int y, String word, char[][] board, boolean[][] visited) {
//         if (cur == word.length() - 1) {
//             return true;
//         }

//         visited[x][y] = true;

//         for (List<Integer> d : dir) {
//             int new_x = x + d.get(0);
//             int new_y = y + d.get(1);

//             if (0 <= new_x && 0 <= new_y && new_x < board.length 
//             && new_y < board[0].length 
//             && !visited[new_x][new_y] 
//             && board[new_x][new_y] == word.charAt(cur + 1)) {
//                 if (dfs(cur + 1, new_x, new_y, word, board, visited)) {
//                     return true;
//                 }
//             }
//         }

//         visited[x][y] = false;
//         return false;
//     }
// }
public class Solution {
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
            board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }
}