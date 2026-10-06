class Solution {
    public int characterReplacement(String s, int k) {
        // X, XYYX
        // Y, YYX

        // A, AAABA
        // B, BABB

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int maxF = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(j)));
            
            while ((j-i+1) - maxF > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            res = Math.max(res, j-i+1);
        }
        
        return res;
    }
}
