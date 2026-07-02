class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        if (max > target) {
            return false;
        }

        // Optimization: Sort and iterate backward to put largest numbers first
        Arrays.sort(nums);
        int[] partitions = new int[k];
        
        return backtrack(nums.length - 1, nums, partitions, target);
    }

    private boolean backtrack(int cur, int[] nums, int[] partitions, int target) {
        // Base case: successfully placed all numbers
        if (cur < 0) {
            return true;
        }

        // Try placing the current number (nums[cur]) into each partition
        for (int j = 0; j < partitions.length; j++) {
            if (partitions[j] + nums[cur] <= target) {
                partitions[j] += nums[cur]; // Choose
                
                if (backtrack(cur - 1, nums, partitions, target)) { // Explore
                    return true;
                }
                
                partitions[j] -= nums[cur]; // Unchoose
            }

            // Optimization: If this partition was empty and nums[cur] didn't work,
            // it won't work in any other empty partition either. Break early.
            if (partitions[j] == 0) {
                break;
            }
        }
        
        return false;
    }
}