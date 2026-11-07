class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            pq.offer(ele);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        while(k-1>= 0) {
            res[k-1] = pq.poll().getKey();
            k--;
        }
        return res;
    }
}
