class Solution {
    public void islandsAndTreasure(int[][] grid) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    pq.offer(List.of(0, i, j));
                }
            }
        }

        while (!pq.isEmpty()) {
            List<Integer> elem = pq.poll();
            int dis = elem.get(0);
            int i = elem.get(1);
            int j = elem.get(2);
            if (grid[i][j] == Integer.MIN_VALUE) {
                grid[i][j] = dis;
            }

            for (int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (grid[x][y] == Integer.MAX_VALUE) {
                        pq.offer(List.of(dis + 1, x, y));
                        grid[x][y] = Integer.MIN_VALUE;
                    }
                }
            }
        }
    }
}
