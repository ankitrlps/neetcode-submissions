class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            var sortedString = new String(chs);
            if (map.containsKey(sortedString)) {
                var vals = map.get(sortedString);
                vals.add(s);
            } else {
                var newList = new ArrayList<String>();
                newList.add(s);
                map.put(sortedString, newList);
            }
        }

        for (String str : map.keySet()) {
            groups.add(map.get(str));
        }

        return groups;
    }
}
