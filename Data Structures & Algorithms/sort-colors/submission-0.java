class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int i = 0;
        int high = nums.length - 1;

        while (i <= high) {
            if (nums[i] == 0) {
                // Swap 0 to the front
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            } else if (nums[i] == 2) {
                // Swap 2 to the back (don't increment 'i' yet, need to check the swapped element)
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            } else {
                // It's a 1, leave it in the middle
                i++;
            }
        }
    }
}