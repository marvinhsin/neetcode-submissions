class StockSpanner {
    // A Monotonic Stack storing int[] pairs: {price, span}
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Pop all previous days that had a lower or equal price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Accumulate their pre-calculated spans
        }
        
        // Push current price and its calculated total span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}