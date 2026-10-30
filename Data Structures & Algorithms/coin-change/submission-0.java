class Solution {
    public int coinChange(int[] coins, int amount) {
        // sort it out
        // start from end
        // if coins[i] > amount continue;
        // else pick the highest available then 
        // dfs from coins[i] < amount
        // recurse on each element till adding will be > amount, dfs to next element and repeat

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= a) {
                    dp[a] = Math.min(dp[a], 1 + dp[a-coins[i]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
