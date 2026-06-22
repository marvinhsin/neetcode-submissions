class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(']', '[');
        pair.put(')', '(');
        pair.put('}', '{');

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            } else {
                if (!st.isEmpty()) {
                    if (pair.get(c) != st.pop()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }
}
