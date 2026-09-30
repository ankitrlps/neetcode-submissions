class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n-1)) { // start of sequence
                int helper = 1;
                while (set.contains(n+helper)) {
                    helper += 1;
                }
                longest = Math.max(longest, helper);
            }
        }
        return longest;
    }
}
