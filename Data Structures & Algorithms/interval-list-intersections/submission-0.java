class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int startA = firstList[i][0], endA = firstList[i][1];
            int startB = secondList[j][0], endB = secondList[j][1];

            int start = Math.max(startA, startB);
            int end = Math.min(endA, endB);

            if (start <= end) {
                res.add(new int[] {start, end});
            }

            if (endA < endB) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}