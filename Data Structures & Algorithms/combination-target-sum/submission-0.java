class Solution {
  // sort it
  // do not need to check if num > target
  // can use one number multiple times

  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new ArrayList<>(), 0, target);
    return res;
  }

  private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> currList,
      int currTotal, int target) {
    if (currTotal == target) {
      res.add(new ArrayList<>(currList));
      return;
    }
    if (i >= nums.length || currTotal > target) {
      return;
    }

    currList.add(nums[i]);
    backtrack(i, nums, res, currList, currTotal + nums[i], target);
    currList.remove(currList.size()-1);
    backtrack(i + 1, nums, res, currList, currTotal, target);
  }
}
