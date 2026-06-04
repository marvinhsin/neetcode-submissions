class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                if (asteroids[i] < 0) {
                    boolean add = true;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                            add = false;
                            break;
                        } else if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                            stack.pop();
                            add = true;
                        } else {
                            stack.pop();
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        stack.push(asteroids[i]);
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}