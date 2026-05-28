class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int h : hand) {
            if (!map.containsKey(h)) {
                map.put(h, 1);
            } else {
                map.put(h, map.get(h) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cur = entry.getKey();
            int toDeduct = entry.getValue();
            if (toDeduct > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (map.containsKey(cur + i) && map.get(cur + i) >= toDeduct) {
                        map.put(cur + i, map.get(cur + i) - toDeduct);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
