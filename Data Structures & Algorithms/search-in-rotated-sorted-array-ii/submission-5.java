class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int p = -1;
        while (l < r) {
            while (l < r && nums[l] == nums[r]) {
                r--;
            }
            int m = (l + r + 1) / 2;
            if (nums[m] > nums[(m + 1) % (nums.length)]) {
                p = m;
                break;
            } 
            if (nums[m] >= nums[l]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (p == -1) p = l;

        if (nums[0] <= target && target <= nums[p]) {
            l = 0;
            r = p;

            while (l <= r) {
                int m = (l + r) / 2;
                if (nums[m] == target) {
                    return true;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return false;
        } else {
            l = (p + 1) % (nums.length);
            r = nums.length - 1;

            while (l <= r) {
                int m = (l + r) / 2;
                if (nums[m] == target) {
                    return true;
                } else if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return false;
        }
    }
}