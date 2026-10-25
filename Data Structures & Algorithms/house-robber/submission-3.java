class Solution {
  public int rob(int[] nums) {
    int prev = 0;
    for (int i = 1; i < nums.length; i++) {
        int temp = nums[i] + prev;
        nums[i] = Math.max(temp, nums[i-1]);
        prev = nums[i-1]; 
    }
    //System.out.println(Arrays.toString(nums));
    return nums[nums.length-1];
  }
}
