class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    // 1. find the start of overlap
    // 2. iterate and grab min and max for generating one main overlap
    // 3. add the rest (non-overalaping) intervals

    List<int[]> res = new ArrayList<>();
    int len = intervals.length, i = 0;
    while (i < len && intervals[i][1] < newInterval[0]) {
      res.add(intervals[i]);
      i++;
    }

    while (i < len && newInterval[1] >= intervals[i][0]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    res.add(newInterval);

    while (i < len) {
      res.add(intervals[i]);
      i++;
    }
    return res.toArray(new int[res.size()][]);
  }
}
