class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
    
        int res = 0;
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastEnd > intervals[i][0]) {
                res++;
                continue;
            }
            lastEnd = intervals[i][1];
        }
        return res;
    }
}
