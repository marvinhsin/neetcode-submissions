class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] res = new int[n];
        
        // 1. Store original index: [enqueueTime, processingTime, originalIndex]
        int[][] extendedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            extendedTasks[i] = new int[] { tasks[i][0], tasks[i][1], i };
        }
        
        // 2. Sort tasks by enqueue time
        Arrays.sort(extendedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 3. Priority Queue: Sorts by processing time, then by index if tied
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        long complete_time = 0; // Use long to prevent integer overflow
        int taskIndex = 0;      // Pointer for extendedTasks
        int resIndex = 0;       // Pointer for res array
        
        // 4. Main simulation loop
        while (resIndex < n) {
            // If PQ is empty and current time is behind the next available task,
            // the CPU went idle! Fast-forward time to the next task's arrival.
            if (pq.isEmpty() && complete_time < extendedTasks[taskIndex][0]) {
                complete_time = extendedTasks[taskIndex][0];
            }
            
            // Push all tasks that have arrived by the current complete_time
            while (taskIndex < n && extendedTasks[taskIndex][0] <= complete_time) {
                pq.offer(extendedTasks[taskIndex]);
                taskIndex++;
            }
            
            // Process the best task available in the queue
            int[] cur_task = pq.poll();
            res[resIndex++] = cur_task[2];
            complete_time += cur_task[1];
        }
        
        return res;
    }
}