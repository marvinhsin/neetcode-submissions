class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        int[] res = new int[tasks.length];
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, (a, b) -> {
            if (a[0] - b[0] == 0) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int complete_time = 0;
        for (int i = 0; i < tasks.length; i++) {
            int cur_time = tasks[i][0];
            //System.out.println("cur_time:"+cur_time+"|complete_time:"+complete_time);
            while (!pq.isEmpty() && complete_time < cur_time) {
                int[] cur_task = pq.poll();
                //System.out.println(cur_task[0]+" "+cur_task[1]);
                arr.add(cur_task[2]);
                if (complete_time == 0) {
                    complete_time = cur_task[0] + cur_task[1];
                } else {
                    complete_time += cur_task[1];
                }
            }
            pq.offer(tasks[i]);
            //System.out.println("=======");
        }
        while (!pq.isEmpty()) {
           //System.out.println(pq.peek()[0]+" "+pq.peek()[1]+" "+pq.peek()[2]);
           arr.add(pq.poll()[2]);
        }
        for (int i = 0; i < tasks.length; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}