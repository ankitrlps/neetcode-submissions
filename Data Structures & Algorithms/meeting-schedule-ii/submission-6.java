/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0;
        int maxRoomsAtAPoint = 0, roomCountRunner = 0;

        while (s < intervals.size()) {
            if (start[s] < end[e]) {
                roomCountRunner++;
                s++;
            } else {
                roomCountRunner--;
                e++;
            }
            maxRoomsAtAPoint = Math.max(maxRoomsAtAPoint, roomCountRunner);
        }

        return maxRoomsAtAPoint;
    }
}
