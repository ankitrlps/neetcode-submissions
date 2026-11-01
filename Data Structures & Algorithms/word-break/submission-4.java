class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
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
}
