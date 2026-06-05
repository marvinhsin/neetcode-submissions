class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = Arrays.stream(strs).mapToInt(String::length).min().orElse(0);
        String res = "";
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean dif = false;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    dif = true;
                    break;
                }
            }
            if (dif) break;
            res += c;
        }
        return res;
    }
}