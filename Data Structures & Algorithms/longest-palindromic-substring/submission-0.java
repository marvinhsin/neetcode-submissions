class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < n + 1; i++) {
            dp[i][i] = true;
            if (i < n) {
                dp[i][i + 1] = true;
                res[0] = i;
                res[1] = i + 1;
            }
        }
        
        for (int dif = 2; dif < n + 1; dif++) {
            for (int i = 0; i < n + 1; i++) {
                int j = i + dif;
                if (j < n + 1) {
                    // System.out.println(i +" "+ j);
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j - 1));
                    if (dp[i][j]) {
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }

        return s.substring(res[0], res[1]);
    }
}
