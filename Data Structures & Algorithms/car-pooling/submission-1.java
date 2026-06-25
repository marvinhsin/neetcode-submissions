class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int cur = 0;
        for (int[] trip : trips) {
            int passenger = trip[0];
            int from = trip[1];
            while (!pq.isEmpty() && pq.peek()[2] <= from) {
                cur -= pq.peek()[0];
                pq.poll();
            }

            cur += passenger;
            if (cur > capacity) {
                return false;
            }
            pq.offer(trip);
        }
        return true;
    }
}