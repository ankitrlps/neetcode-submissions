class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0, maxF = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(right)));

            while ((right - left + 1) - maxF > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right-left+1);
        }

        return res;
    }
}
