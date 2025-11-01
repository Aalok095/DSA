class Solution {
    public long coinsCount(int i,int[] coins,int amount,int[][] dp){
        if(i==coins.length){
            if(amount==0) return 0;// no more coins needed
            else return Integer.MAX_VALUE;// not a valid combination
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        long skip = coinsCount(i+1,coins,amount,dp);
        if(amount-coins[i]<0) return skip;
        long pick = 1 + coinsCount(i,coins,amount-coins[i],dp);
        return dp[i][amount] = (int)Math.min(skip,pick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = (int) coinsCount(0,coins,amount,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}