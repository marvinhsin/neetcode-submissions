class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            d[target - nums[i]] = i
        for i in range(len(nums)):
            if nums[i] in d and i != d[nums[i]]:
                return [d[nums[i]], i] if d[nums[i]] < i else [i, d[nums[i]]]

        