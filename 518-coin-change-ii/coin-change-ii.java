class Solution {
    public int coinsCount(int i,int[] coins,int amount,int[][] dp){
        if (i == coins.length || amount == 0) return (amount == 0) ? 1 : 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int skip = coinsCount(i+1,coins,amount,dp);
        int pick = 0;
        if (amount >= coins[i]) pick = coinsCount(i,coins,amount-coins[i],dp);
        return dp[i][amount] = skip + pick;
        
    }
    public int change(int amount,int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return coinsCount(0,coins,amount,dp);
    }
}