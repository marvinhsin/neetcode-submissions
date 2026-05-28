class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a == b) {
                continue;
            } else {
                pq.offer(Math.abs(a - b));
            }
            // System.out.println(pq.peek());
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
