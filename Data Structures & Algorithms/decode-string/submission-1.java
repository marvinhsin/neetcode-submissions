class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                String cur = "";
                String res = "";
                String n = "";
                while (!st.isEmpty()) {
                    if (st.peek() == '[') {
                        st.pop();
                        while (!st.isEmpty() && Character.isDigit(st.peek())) {
                            n = st.pop() + n;
                        }
                        break;
                    } else {
                        cur = st.pop() + cur;
                    }
                }
                for (int i = 0; i < Integer.parseInt(n); i++) {
                    res += cur;
                }
                for (char ch : res.toCharArray()) {
                    st.push(ch);
                }
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}