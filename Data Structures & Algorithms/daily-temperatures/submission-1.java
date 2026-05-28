class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (i == 0) {
                stack.push(List.of(temperatures[i], 0));
            } else {
                while (!stack.isEmpty() && temperatures[i] > stack.peek().get(0)) {
                    List<Integer> elem = stack.pop();
                    res[elem.get(1)] = i - elem.get(1);
                } 

                stack.push(List.of(temperatures[i], i));
            }
        }
        return res;
    }
}
