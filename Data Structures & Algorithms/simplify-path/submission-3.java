class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            } else {
                String cur = "";
                while (i < path.length() && path.charAt(i) != '/') {
                    cur += path.charAt(i);
                    i++;
                }
                if (cur.equals("..")) {
                    if (!s.isEmpty()) s.pop();
                } else if (cur.equals(".")) {
                    continue;
                } else {
                    s.push(cur);
                }
            }
        }
        StringJoiner sj = new StringJoiner("/");
        for (String str : new ArrayList<>(s)) {
            sj.add(str);
        }
        return "/" + sj.toString();
    }
}