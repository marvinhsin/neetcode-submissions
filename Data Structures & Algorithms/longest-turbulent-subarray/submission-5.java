class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0;
        int max_len = 1;
        String prev = "";
        for (int right = 1; right < n; right++) {
            if (arr[right] > arr[right - 1] && !prev.equals(">")) {
                max_len = Math.max(max_len, right - left + 1);
                prev = ">";
            } else if (arr[right] < arr[right - 1] && !prev.equals("<")) {
                max_len = Math.max(max_len, right - left + 1);
                prev = "<";
            } else if (arr[right] == arr[right - 1]) {
                prev = "";
                left = right;
                continue;
            } else {
                left = right - 1;
                prev = (arr[right] > arr[right - 1]) ? ">" : "<";
            }
            //System.out.println(left + " " + right + " " + max_len);
        }
        return max_len;
    }
}