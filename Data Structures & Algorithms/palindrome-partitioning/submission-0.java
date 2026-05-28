class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        List<String> cur = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (i != j) {
                    System.out.println(i+" "+ j);
                    dp[i][j] = isPalindrome(s.substring(i, j));
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        backtrack(0, cur, res, dp, s.length() + 1, s);
        return res;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private void backtrack(int start, List<String> cur, List<List<String>> res, boolean[][] dp, int target, String s) {
        if (start == target - 1) {
            res.add(new ArrayList<>(cur));
        }
        // System.out.println(cur);
        for (int i = start + 1; i < target; i++) {
            String subStr = s.substring(start, i);
            if (dp[start][i]) {
                cur.add(subStr);
                backtrack(i, cur, res, dp, target, s);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
