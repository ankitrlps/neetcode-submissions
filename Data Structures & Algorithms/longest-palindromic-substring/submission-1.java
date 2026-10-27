class Solution {
  public String longestPalindrome(String s) {
    int len = s.length();
    String res = "";

    for (int i = 0; i < len; i++) {
      
      // ==> ODD - start from same char and then expand
      int m = i, n = i;
      while (m >= 0 && n < len && s.charAt(m) == s.charAt(n)) {
        m--;
        n++;
      }
      m++; // reverting to previously matched char
      n--; // reverting to previously matched char
      if (res.length() < n - m + 1) {
        res = s.substring(m, n + 1);
      }

      // ==> EVEN - start from two next to each other and then expand
      m = i;
      n = i + 1;
      while (m >= 0 && n < len && s.charAt(m) == s.charAt(n)) {
        m--;
        n++;
      }
      m++; // reverting to previously matched char
      n--; // reverting to previously matched char

      if (res.length() < n - m + 1) {
        res = s.substring(m, n + 1);
      }
    }
    return res;
  }
}
