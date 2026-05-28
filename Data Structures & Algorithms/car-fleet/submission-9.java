class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        double prev_time = (double) (target - pair[0][0]) / pair[0][1];
        int fleet = 1;
        for (int i = 1; i < n; i++) {
            double cur_time = (double) (target - pair[i][0]) / pair[i][1];
            System.out.println(cur_time+" "+ n);
            if (cur_time > prev_time) {
                fleet++;
                prev_time = cur_time;
            }
        }
        return fleet;
    }
}
