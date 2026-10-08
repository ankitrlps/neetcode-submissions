class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) return nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i-1] > nums[i]) return nums[i];
        // }
        // return Integer.MIN_VALUE;

        int l = 0, r = nums.length-1;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int mid = l + (r-l) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
