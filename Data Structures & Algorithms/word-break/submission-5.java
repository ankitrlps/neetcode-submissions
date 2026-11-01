class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    return sol1(s, wordDict); // own solution - traverse once from left and once from right
    // return sol2(s, wordDict); // using DP (bottom up)
  }

  private boolean sol1(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);

    // Starting from LEFT
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.substring(start, i + 1))) {
        // checking one more char in case of s at the ends
        if (i + 1 < s.length() && set.contains(s.substring(start, i + 2))) {
          start = i + 2;
        } else {
          start = i + 1;
        }
      }
    }
    if (start == s.length())
      return true;

    // Starting from RIGHT
    int end = s.length();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (set.contains(s.substring(i, end))) {
        end = i;
      }
    }
    return end == 0 ? true : false;
  }

  private boolean sol2(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[dp.length - 1] = true;

    for (int i = s.length() - 1; i >= 0; i--) {
      for (String word : wordDict) {
        int wLen = word.length();
        if (i + wLen <= s.length() && s.substring(i, i + wLen).equals(word)) {
          dp[i] = dp[i + wLen];
        }
        if (dp[i])
          break;
      }
    }
    return dp[0];
  }
}
