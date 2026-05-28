class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // Pad the array by +1 to handle empty string base cases safely
        int[][] dp = new int[m + 1][n + 1];
        
        // i and j represent lengths of the substrings, starting at 1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Check characters at i-1 and j-1 because string indexing starts at 0
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                   dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        // The bottom-right corner holds the answer for full lengths m and n
        return dp[m][n];
    }
}