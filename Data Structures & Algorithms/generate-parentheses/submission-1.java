class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        backtrack(0, 0, str, n, res);
        return res;
    }

    private void backtrack(int open, int close, StringBuilder cur, int n, List<String> res) {
        if (open == close && open == n) {
            res.add(cur.toString());
        }

        if (open < n) {
            cur.append("(");
            backtrack(open + 1, close, cur, n, res);
            cur.delete(cur.length() - 1, cur.length());
        }
        System.out.println(open + " " + close + " " + cur);
        if (close < open) {
            cur.append(")");
            backtrack(open, close + 1, cur, n, res);
            cur.delete(cur.length() - 1, cur.length());
        }
    }
}
