class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }

    private int bs(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) {
                return bs(nums, l, mid - 1, target);
            } else {
                return bs(nums, mid + 1, r, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1;
                return bs(nums, mid + 1, r, target);
            } else {
                r = mid - 1;
                return bs(nums, l, mid - 1, target);
            }
        }
    }
}
