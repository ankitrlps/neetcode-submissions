class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // if (nums.length == 3) {
        //     List<Integer> li = new ArrayList();
        //     li.add(nums[0]);
        //     li.add(nums[1]);
        //     li.add(nums[2]);
        //     res.add(li);
        // }
        // [-1,0,1,2,-1,-4]
        // [-1, 0, 1] -- true
        // [-1, 0, 2] -- false
        // [-1, 0, -1] -- true
        // [-1, 0, -4] -- false

        // [-1, 1, 2] -- false
        // [-1, 1, -1] -- false
        // [-1, 1, -4] -- false

        // [-1, 2, -1] -- true but duplicate
        // [-1, 2, -4] -- false

        // [-1, -1, -4] -- false

        // [0, 1, 2] -- false
        // [0, 1, -1] -- true but duplicate
        // [0, 1, -4] -- false

        // [0, 2, -1] -- false
        // [0, 2, -4] -- false

        // [1, 2, -1] -- false
        // [1, 2, -4] -- false

        // [1, -1, -4] -- false

        // [2, -1, -4] -- false

        // for (int i = 0; i <= nums.length - 3; i++) {
        //     for (int j = i + 1; j <= nums.length - 2; j++) {
        //         for (int k = j + 1; k < nums.length - 1; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 if (res.isEmpty()) {
        //                     List<Integer> newList = new ArrayList<>();
        //                     newList.add(nums[i]);
        //                     newList.add(nums[j]);
        //                     newList.add(nums[k]);
        //                     res.add(newList);
        //                 } else {
        //                     List<Integer> newList1 = new ArrayList<>();
        //                     for (List<Integer> list : res) {
        //                         if (!(list.contains(nums[i]) && list.contains(nums[j])
        //                                 && list.contains(nums[k]))) {
        //                             newList1.add(nums[i]);
        //                             newList1.add(nums[j]);
        //                             newList1.add(nums[k]);
        //                         } else {
        //                             break;
        //                         }
        //                     }
        //                     if (!newList1.isEmpty()) {
        //                         res.add(newList1);
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                }
            }
        }
        return res;
    }
}
