class Solution {
    public int rob(int[] nums) {
        int h1 = 0;
        int h2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int maxSum = Math.max(h1+nums[i], h2);
            h1 = h2;
            h2 = maxSum;
        }
        return h2;
    }
}
