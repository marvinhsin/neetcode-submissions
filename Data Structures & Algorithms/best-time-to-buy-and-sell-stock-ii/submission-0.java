class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        // Start from day 1 and compare each day to the previous day
        for (int i = 1; i < prices.length; i++) {
            // If the price increased compared to yesterday, lock in the profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}