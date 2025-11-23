class Solution {
    public int helper(int i,int rem,int[] arr,int[][] dp){
        if(i==arr.length) return rem==0 ? 0 : Integer.MIN_VALUE;
        if(dp[i][rem] != -1) return dp[i][rem];
        int take = arr[i]+helper(i+1,(rem+arr[i])%3,arr,dp);
        int skip = helper(i+1,rem,arr,dp);
        return dp[i][rem] = Math.max(take,skip);
    }
    public int maxSumDivThree(int[] arr) {
        int n = arr.length;
        // i-> 0 to n-1 || rem -> 0 to 2 
        int[][] dp = new int[n][3];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,arr,dp);
    }
}