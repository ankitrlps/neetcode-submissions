class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    // the idea is to only accept the smallest end interval so that
    // more intervals will be kept i.e. less intervals will be removed

    // Sort by end interval and only set lastEnd with first min end interval and keep
    // comparing with start of each next interval
    return sol1(intervals);

    // Sort by start interval and set min
    // lastEnd from previous vs current end interval during an overlap
    //return sol2(intervals);
  }

  private int sol1(int[][] intervals) {
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

  private int sol2(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    int res = 0;
    int lastEnd = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (lastEnd > intervals[i][0]) {
        res++;
        lastEnd = Math.min(lastEnd, intervals[i][1]);
        continue;
      }
      lastEnd = intervals[i][1];
    }
    return res;
  }
}
