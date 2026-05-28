class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int min_l = 0;
        int min_r = 0;
        int have = 0;
        int min_window = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        if (t.isEmpty()) return "";

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int need = map.size();
        for (int r = 0; r < s.length(); r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);
            if (map.containsKey(s.charAt(r)) && window.get(s.charAt(r)) == map.get(s.charAt(r))) {
                have++;
            }
            while (have == need) {
                if (r - l + 1 < min_window) {
                    min_window = r - l + 1;
                    min_l = l;
                    min_r = r;
                }

                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                if (map.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < map.get(s.charAt(l))) {
                    have--;
                }
                l++;
            }
        }
        return min_window == Integer.MAX_VALUE ? "" : s.substring(min_l, min_r + 1);
    }
}
