class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        // Pad the matrix by 1 to completely avoid out-of-bounds checks
        prefixSum = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Map to padded indices: i -> i+1, j -> j+1
                prefixSum[i + 1][j + 1] = matrix[i][j] 
                                        + prefixSum[i][j + 1] 
                                        + prefixSum[i + 1][j] 
                                        - prefixSum[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Shift all coordinates up by 1 to align with the padded prefix array
        return prefixSum[row2 + 1][col2 + 1] 
             - prefixSum[row1][col2 + 1] 
             - prefixSum[row2 + 1][col1] 
             + prefixSum[row1][col1];
    }
}