class Solution {
    public int helper(int i,int j,int m,int n,int[] n1,int[] n2,int[][] dp){
        if(i==m || j==n) return Integer.MIN_VALUE/2;
        if(dp[i][j]!=-1) return dp[i][j];
        int take = n1[i]*n2[j];
        int take_i = helper(i,j+1,m,n,n1,n2,dp);
        int take_j = helper(i+1,j,m,n,n1,n2,dp);
        int take_i_j = take + helper(i+1,j+1,m,n,n1,n2,dp);
        return dp[i][j] = Math.max(take,Math.max(take_i,Math.max(take_j,take_i_j)));
    }
    public int maxDotProduct(int[] n1, int[] n2) {
        int m = n1.length,n = n2.length;
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(0,0,m,n,n1,n2,dp);
    }
}