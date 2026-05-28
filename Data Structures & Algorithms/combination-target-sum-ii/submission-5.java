class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(0, 0, cur, candidates, res, target);
        return new ArrayList<>(res);
    }

    private void backtrack(int start, int total, List<Integer> cur, int[] nums, Set<List<Integer>> res, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
        } else if (total > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            if (!res.contains(cur)) {
               backtrack(i + 1, total + nums[i], cur, nums, res, target); 
            }
            cur.remove(cur.size() - 1);
        }

    }
}
