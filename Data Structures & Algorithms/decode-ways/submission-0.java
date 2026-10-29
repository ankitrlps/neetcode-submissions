class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s.length(), 1);
        return dfs(s, 0, map);
    }

    private int dfs(String s, int i, Map<Integer, Integer> map) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int res = dfs(s, i+1, map);
        if (i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) <'7')) {
            res += dfs(s, i+2, map);
        }
        map.put(i, res);
        return res;
    }
}
 