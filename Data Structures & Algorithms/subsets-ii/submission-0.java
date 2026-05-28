class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        s.add(new ArrayList<>());
        List<Integer> cur = new ArrayList<>();
        backtrack(0, nums, cur, s);
        return new ArrayList<>(s);
    }

    private void backtrack(int start, int[] nums, List<Integer> cur, Set<List<Integer>> s) {
        // System.out.println(cur);
        
        s.add(new ArrayList(cur));
        

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, nums, cur, s);
            cur.remove(cur.size() - 1);
        }
    }
}
