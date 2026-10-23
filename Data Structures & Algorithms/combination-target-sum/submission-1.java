class Solution {
  // sort it
  // do not need to check if num > target
  // can use one number multiple times

  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new ArrayList<>(), 0, target);
    return res;
  }

  //                .
  //            [2]   []
  //        [2,2]      [3]
  //   [2,2,2]  [2,2]
// there's two path on each nums element
// first path will i element then backtrack to i+1
// second path will i+1 element then backtrack to i+1 then i+2

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
