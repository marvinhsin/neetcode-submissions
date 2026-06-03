class Solution {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int l = 0;
        Map<Integer, Integer> collected = new HashMap<>();
        for (int r = 0; r < fruits.length; r++) {
            collected.put(fruits[r], collected.getOrDefault(fruits[r], 0) + 1);
            while (collected.size() > 2) {
                collected.put(fruits[l], collected.getOrDefault(fruits[l], 0) - 1);
                if (collected.get(fruits[l]) == 0) {
                    collected.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}