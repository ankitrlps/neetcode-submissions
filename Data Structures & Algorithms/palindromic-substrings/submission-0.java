class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        // a, a, aaa, a
        for (int i = 0; i < s.length(); i++) {
            int m = i, n = i;
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                res++;
                m--;
                n++;
            }
            
            m = i;
            n = i+1;
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
                res++;
                m--;
                n++;
            }
        }
        return res;
    }
}
