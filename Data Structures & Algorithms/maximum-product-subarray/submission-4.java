class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1, max = 1;
        for (int n : nums) {
            int temp = n * min; // storing for whatever the second in order: min/max coz first one changes value
            min = Math.min(Math.min(n*min, n*max), n);
            max = Math.max(Math.max(temp, n*max), n);
            res = Math.max(res, max);
        }
        return res;
    }
}
