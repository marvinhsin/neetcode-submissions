class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        // 1. Base case
        if (end - start <= 1) return;

        int pivot = nums[end - 1];
        int index = start;

        // 3. Partitioning loop
        for (int i = start; i < end - 1; i++) {
            if (nums[i] < pivot) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        // 4. Put pivot in its correct final place
        nums[end - 1] = nums[index];
        nums[index] = pivot;

        // 5. Correct recursive boundaries
        quickSort(start, index, nums);
        quickSort(index + 1, end, nums);
    }
}