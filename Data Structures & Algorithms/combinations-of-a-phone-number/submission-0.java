class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
        backtrack(0, str, res, map, digits);
        return res;
    }

    private void backtrack(int start, StringBuilder cur, List<String> res, Map<Character, List<String>> map, String digits) {
        if (cur.length() == digits.length()) {
            res.add(cur.toString());
        }
        
        if(start == digits.length()) return;

        for (String ch : map.get(digits.charAt(start))) {
            cur.append(ch);
            backtrack(start + 1, cur, res, map, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
