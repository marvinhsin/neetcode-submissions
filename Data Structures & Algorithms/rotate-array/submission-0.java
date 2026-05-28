class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than array length
        
        // 1. Create a temporary array to store the sliced elements
        int[] result = new int[n];
        
        // 2. Copy the second part (the elements that move to the front)
        System.arraycopy(nums, n - k, result, 0, k);
        
        // 3. Copy the first part (the elements pushed to the back)
        System.arraycopy(nums, 0, result, k, n - k);
        
        // 4. Copy the result back into the original nums array
        System.arraycopy(result, 0, nums, 0, n);
    }
}