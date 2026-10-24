class Solution {
    public int climbStairs(int n) {

// traverse from end to 1
        // int one = 1, two = 1;
        // for (int i = n -1; i > 0; i--) {
        //     int temp = one;
        //     one = one + two;
        //     two = temp;
        // }
        // return one;

// traverse from start TILL n
        int[] results = new int[n+1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i-2] + results[i-1];
        }
        return results[n];
    }
}
