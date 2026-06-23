class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canLoad(weights, mid, days)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canLoad(int[] weights, int load, int days) {
        int cur = 0;
        int ships = 0;
        for (int w : weights) {
            if (cur + w > load) {
                ships++;
                if (ships > days) return false;
                cur = w;
            } else {
                cur += w;
            }
        }
        //System.out.println(load +" | "+ships);
        return ships + 1 <= days;
    }
}