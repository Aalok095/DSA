class Solution {
    public int ways(int m,int n,int[][] dp){
        if(m<0 || n<0) return 0;
        if(m==0 || n==0) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n] = ways(m-1,n,dp)+ways(m,n-1,dp);
    }
    public int uniquePaths(int m, int n) {
        // row 0 to m-1   |   col 0 to n-1
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
        Arrays.fill(row,-1);
        }
        return ways(m-1,n-1,dp);
    }
}