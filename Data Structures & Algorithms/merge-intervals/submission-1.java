class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size()-1);
            if (last[1] >= intervals[i][0]) {
                last[0] = Math.min(last[0], intervals[i][0]);
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
