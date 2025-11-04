class Solution {
    public int ways(int n,int k,int t,int[][] dp){
        if(t<0 || n==0) return t==0 ? 1 : 0;
        if(dp[n][t]!=-1) return dp[n][t];
        int sum = 0;
        for(int i = 1;i<=k;i++){
            sum += ways(n-1,k,t-i,dp);
            sum %= (int)1000000007;
        }
        return dp[n][t] = sum;
    }
    public int numRollsToTarget(int n, int k, int t) {
        //n -> 0 to n | target -> target to 0 
        int[][] dp = new int[n+1][t+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return ways(n,k,t,dp);
    }
}