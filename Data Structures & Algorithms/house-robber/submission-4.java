class Solution {
  public int rob(int[] nums) {
    // orig: [2,1,1,2]
    // format: prev [h1, h2, h, h+1 ...]
    // ans:  [2,2,3,4]
    int prev = 0;
    for (int i = 1; i < nums.length; i++) {
        int temp = nums[i] + prev;
        nums[i] = Math.max(temp, nums[i-1]);
        prev = nums[i-1]; 
    }
    return nums[nums.length-1];
  }
}
