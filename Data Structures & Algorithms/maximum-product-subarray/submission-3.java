class Solution {
    public int maxProduct(int[] nums) {
        // [2, 8, -24, -120]
        // [-120, -60, -15, 5]
        // [-3, 0, 0]
        int res = nums[0];
        int min = 1, max = 1;
        for (int n : nums) {
            int temp = n * min;
            min = Math.min(Math.min(n*min, n*max), n);
            max = Math.max(Math.max(temp, n*max), n);
            res = Math.max(res, max);
        }
        return res;
    }
}
