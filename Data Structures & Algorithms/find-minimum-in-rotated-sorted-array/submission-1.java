class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) return nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) return nums[i];
        }
        return Integer.MIN_VALUE;
    }
}
