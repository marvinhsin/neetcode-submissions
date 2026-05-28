class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                for (int left = 0; left < dp.get(j).size(); left++) {
                    for (int right = 0; right < dp.get(i - j - 1).size(); right++) {
                        dp.get(i).add("(" + dp.get(j).get(left) + ")" + dp.get(i - j - 1).get(right));
                    }
                }
            }
        }
        return dp.get(n);
    }


    // public List<String> generateParenthesis(int n) {
    //     List<String> res = new ArrayList<>();
    //     StringBuilder str = new StringBuilder();
    //     backtrack(0, 0, str, n, res);
    //     return res;
    // }

    // private void backtrack(int open, int close, StringBuilder cur, int n, List<String> res) {
    //     if (open == close && open == n) {
    //         res.add(cur.toString());
    //     }

    //     if (open < n) {
    //         cur.append("(");
    //         backtrack(open + 1, close, cur, n, res);
    //         cur.delete(cur.length() - 1, cur.length());
    //     }
    //     System.out.println(open + " " + close + " " + cur);
    //     if (close < open) {
    //         cur.append(")");
    //         backtrack(open, close + 1, cur, n, res);
    //         cur.delete(cur.length() - 1, cur.length());
    //     }
    // }
}
