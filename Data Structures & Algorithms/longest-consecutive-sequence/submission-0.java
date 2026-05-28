class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int maxLen = 0;
        for (int num : nums) {
            map.put(num, true);
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            int key = entry.getKey();
            int upper = key, lower = key;
            if (!seen.contains(key)) {
                int count = 1;
                while (map.containsKey(lower - 1) && !seen.contains(lower - 1)) {
                    seen.add(lower - 1);
                    count++;
                    lower--;
                }
                while (map.containsKey(upper + 1) && !seen.contains(upper + 1)) {
                    seen.add(upper + 1);
                    count++;
                    upper++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
