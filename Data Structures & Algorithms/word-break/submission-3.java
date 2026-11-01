class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>(wordDict);
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.substring(start, i + 1))) {
        if (i + 1 < s.length() && set.contains(s.substring(start, i + 2))) {
          start = i + 2;
        } else {
          start = i + 1;
        }
      }
    }
    if (start == s.length())
      return true;

    start = s.length();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (set.contains(s.substring(i, start))) {
        start = i;
      }
    }

    return start == 0 ? true : false;
  }
}
