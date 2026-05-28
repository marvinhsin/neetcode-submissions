class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(0, 0, cur, nums, res, target);
        return res;
    }

    private void backtrack(int start, int sum, List<Integer> cur, int[] nums, List<List<Integer>> res, int target) {
        // int sum = cur.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            res.add(new ArrayList(cur));
        } else if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i, sum + nums[i], cur, nums, res, target);
            cur.remove(cur.size() - 1);
        }
    }
}
