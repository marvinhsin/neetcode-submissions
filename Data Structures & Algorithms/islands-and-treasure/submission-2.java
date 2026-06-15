class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Add all treasure chests (0) to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int[] d : dir) {
                int x = r + d[0];
                int y = c + d[1];
                
                // Only traverse if within bounds and it's an unvisited empty room
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == Integer.MAX_VALUE) {
                    // Update distance directly
                    grid[x][y] = grid[r][c] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}