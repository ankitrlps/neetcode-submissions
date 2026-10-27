class Solution {
  public String longestPalindrome(String s) {
    // char[] ch = s.toCharArray();
    int i = 0;
    int len = s.length();
    String res = "";
    while (i < len) {
      // odd one - start from same char and then expand
      int m = i, n = i;
      while (m >= 0 && n < len && s.charAt(m) == s.charAt(n)) {
        m--;
        n++;
      }
      m++;
      n--;
      if (res.length() < n - m + 1) {
        res = s.substring(m, n + 1);
      }

      // even one - start from two next to each other and then expand
      m = i; 
      n = i + 1;
      while (m >= 0 && n < len && s.charAt(m) == s.charAt(n)) {
        m--;
        n++;
      }
      m++;
      n--;

      if (res.length() < n - m + 1) {
        res = s.substring(m, n + 1);
      }

      i++;
    }
    return res;
  }
}
