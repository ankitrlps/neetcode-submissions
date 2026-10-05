class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        // Map<String, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        // char[] ch = s.toCharArray();
        int i = 0, j = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            while (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}
