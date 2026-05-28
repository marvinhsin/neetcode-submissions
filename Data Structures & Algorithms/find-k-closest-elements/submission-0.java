class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        l = l - 1;
        r = l + 1;
        int total = 1;
        while (total <= k) {
            if (l < 0) {
                r++;
            } else if (r >= arr.length) {
                l--;
            } else if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                l--;
            } else {
                r++;
            }
            total++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l + 1; i < r; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}