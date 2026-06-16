class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int limit = nums.length / 3;
        Arrays.sort(nums);
        int last_idx = 0;
        int last = nums[0];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == last) {
                continue;
            } else {
                if (i - last_idx > limit) {
                    System.out.println(i + " "+ last+" "+last_idx);
                    res.add(last);
                }
                last = nums[i];
                last_idx = i;
            }
        }
        if (nums.length - last_idx > limit) {
            res.add(last);
        }
        return res;
    }
}