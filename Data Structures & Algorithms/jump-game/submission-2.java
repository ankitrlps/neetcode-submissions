class Solution {
  public boolean canJump(int[] nums) {
    int targetIndex = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= targetIndex) {
        targetIndex = i;
      }
    }
    return targetIndex == 0;
  }
}
