class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Double>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.get(0), a.get(0)));
        for (int[] point : points) {
            pq.offer(List.of(getDistance(point), (double) point[0], (double) point[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            List<Double> elem = pq.poll();
            int[] p = new int[] {elem.get(1).intValue(), elem.get(2).intValue()};
            res[i] = p;
            i++;
        }
        return res;
    }

    private double getDistance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
