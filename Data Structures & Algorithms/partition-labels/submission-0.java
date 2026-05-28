class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int last = -1;
        List<Integer> res = new ArrayList<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) > 0) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                set.add(c);
                if (map.get(c) == 0) {
                    // System.out.println(i +"|"+ c + "|");
                    boolean done = true;
                    for (Character ch : set) {
                        if (map.get(ch) > 0) {
                            done = false;
                            break;
                        }
                    }
                    if (done) {
                        res.add(i - last);
                        last = i;
                        set.clear();
                    }
                }
            }
        }
        return res;
    }
}
