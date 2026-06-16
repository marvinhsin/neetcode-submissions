class CountSquares {
    // Since constraints say 0 <= x, y <= 1000
    private int[][] counts;
    private Map<Integer, List<Integer>> xToYs;

    public CountSquares() {
        counts = new int[1001][1001];
        xToYs = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        counts[x][y]++;
        
        // Group y-coordinates by their x-coordinate
        xToYs.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int res = 0;
        
        // If we haven't seen any points on this X-axis, no squares can be formed
        if (!xToYs.containsKey(qx)) {
            return 0;
        }
        
        // Iterate only through points that share the same X coordinate (potential vertical edges)
        for (int y : xToYs.get(qx)) {
            if (y == qy) continue; // Skip the query point itself
            
            // The vertical distance determines the required side length of the square
            int side = Math.abs(y - qy);
            
            // Case 1: The square expands to the right (x = qx + side)
            int rx1 = qx + side;
            if (rx1 <= 1000) {
                res += counts[rx1][qy] * counts[rx1][y];
            }
            
            // Case 2: The square expands to the left (x = qx - side)
            int rx2 = qx - side;
            if (rx2 >= 0) {
                res += counts[rx2][qy] * counts[rx2][y];
            }
        }
        
        return res;
    }
}