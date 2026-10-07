class Solution {
    public String minWindow(String s, String t) {
        // Map<Character, Integer> count = new HashMap<>();

        // for (char c : t.toCharArray()) {
        //     count.put(c, count.getOrDefault(c, 0) + 1);
        // }

        // int startWin = s.length();
        // int endWin = 0;

        // for (int i = 0; i < s.length(); i++) {
        //     if (count.containsKey(s.charAt(i))) {
        //         startWin = Math.min(startWin, i);
        //         endWin = Math.max(endWin, i);
        //         count.put(s.charAt(i), count.get(s.charAt(i)) - 1);
        //     }
        // }

        // String window = s.substring(startWin, endWin + 1);

        // Set<Character> countSet = new HashSet<>();
        // for (char c : t.toCharArray()) {
        //     countSet.add(c);
        // }
        // System.out.println(window);
        // int i = 0;
        // int tCount = t.length();
        // startWin = 0;
        // endWin = window.length();
        // for (int j = 0; j < window.length(); j++) {
        //     System.out.println(j + " " + tCount);
        //     if (countSet.contains(window.charAt(j))) {
        //         tCount--;
        //     }

        //     if (tCount == 0) {
        //         System.out.println("tCount zero: " + (j - i));
        //         if (endWin - startWin > j - i) {
        //             startWin = i;
        //             endWin = j;
        //             System.out.println(startWin + " | " + endWin);
        //         }
        //         i++;
        //         while (!countSet.contains(window.charAt(i)) && i <= j) {
        //             i++;
        //         }
        //         tCount--;
        //     }
        // }

        // return window.substring(startWin, endWin+1);
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
