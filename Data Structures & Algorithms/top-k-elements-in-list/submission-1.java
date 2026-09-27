class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            pq.offer(m);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        while (!pq.isEmpty()) {
            res[--k] = pq.poll().getKey();
        }
         
        return res;
    }
}
