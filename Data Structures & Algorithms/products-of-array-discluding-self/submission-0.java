class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [48,48,24,6]
        // [1,2,8,24]
        // [48,24,12,8]
        
        // [0,0,6,6,3]
        // [-1,0,0,0,0]
        // [0,-6,0,0,0]
        int[] rightMul = new int[nums.length];
        int[] leftMul = new int[nums.length];
        int helpMul = 1;
        for (int i = 0; i < nums.length; i++) {
            helpMul *= nums[i];
            leftMul[i] = helpMul;
        }

        helpMul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            helpMul *= nums[i];
            rightMul[i] = helpMul;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            int lefty = 1;
            int righty = 1;
            if (i-1 < 0) {
                lefty = 1;
            } else {
                lefty = leftMul[i-1];
            }

            if (i+1 == res.length) {
                righty = 1;
            } else {
                righty = rightMul[i+1];
            }

            res[i] = lefty * righty;
        }
        return res;
    }
}  
