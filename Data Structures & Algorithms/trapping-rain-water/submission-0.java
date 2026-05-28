class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        int res = 0;

        for (int i = 0; i < size; i++) {
            if (i > 0) {
               left_max[i] = Math.max(left_max[i - 1], height[i]);
            } else {
                left_max[i] = height[i];
            }
    
        }
        for (int i = size - 1; i >= 0; i--) {
            if (i < size - 1) {
                right_max[i] = Math.max(right_max[i + 1], height[i]);
            } else {
                right_max[i] = height[i];
            }

        }

        for (int i = 0; i < size; i++) {
            res = res + Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
}
