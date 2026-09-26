class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i = n-2; i >= 0; i--) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
